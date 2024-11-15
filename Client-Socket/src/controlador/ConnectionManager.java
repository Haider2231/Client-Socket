package controlador;

import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 * ConnectionManager gestiona la conexión con el servidor y la recepción de 
 * datos. Se encarga de establecer la conexión, recibir códigos y manejar 
 * reconexiones en caso de error.
 */
public class ConnectionManager {

    private static final String SERVER_IP = "172.16.127.87";
    private static final int SERVER_PORT = 5000;
    private static final int RECONNECT_DELAY = 5000;
    private Controlador controlador;

    /**
     * Constructor de ConnectionManager.
     * @param controlador Instancia del controlador que procesará los códigos recibidos.
     */
    public ConnectionManager(Controlador controlador) {
        this.controlador = controlador;
    }

    /**
     * Inicia la conexión al servidor y recibe códigos en un bucle.
     * En caso de fallo, intenta reconectar después de un retraso.
     */
    public void startListening() {
        while (true) {
            try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                 ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                while (true) {
                    Integer code = (Integer) in.readObject();
                    if (code != null) {
                        controlador.procesarCodigo(code);
                        Thread.sleep(1000);
                    } else {
                        break;
                    }
                }

                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo conectar al servidor. Reintentando en 5 segundos...",
                        "Error de conexión", JOptionPane.WARNING_MESSAGE);

                try {
                    Thread.sleep(RECONNECT_DELAY);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }
}
