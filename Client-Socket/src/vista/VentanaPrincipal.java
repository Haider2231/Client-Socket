package vista;

import controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import mundo.LWZ;

/**
 * VentanaPrincipal es la ventana principal de la aplicación que inicializa 
 * y configura los paneles de texto y código, así como el controlador de la aplicación.
 * Configura la interfaz y lanza la conexión con el servidor.
 */
public class VentanaPrincipal extends JFrame {

    private PnlTexto pnlTexto;
    private PnlCodigo pnlCodigo;
    private Controlador controlador;
    private LWZ lwz;

    /**
     * Constructor de VentanaPrincipal.
     * Configura el layout, el controlador y establece los componentes de la interfaz.
     */
    public VentanaPrincipal() {
        setTitle("Cliente");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setBackground(new Color(240, 240, 240));

        pnlTexto = new PnlTexto();
        pnlCodigo = new PnlCodigo();
        lwz = new LWZ();
        controlador = new Controlador();

        add(pnlCodigo, BorderLayout.NORTH);
        add(pnlTexto, BorderLayout.CENTER);

        controlador.conectar(lwz, pnlTexto, pnlCodigo);

        setVisible(true);

        controlador.recibirYMostrar();
    }

    /**
     * Método principal de la aplicación.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}


