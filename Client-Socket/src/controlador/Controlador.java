package controlador;

import javax.swing.JOptionPane;
import mundo.LWZ;
import vista.PnlCodigo;
import vista.PnlTexto;

/**
 * Controlador gestiona la lógica de la aplicación, conectando el modelo (LWZ) 
 * con los paneles de vista y coordinando la recepción y visualización de datos.
 */
public class Controlador {

    private LWZ modelo;
    private PnlTexto pnlText;
    private PnlCodigo pnlCodigo;
    private ConnectionManager connectionManager;

    /**
     * Constructor del Controlador.
     * Inicializa el gestor de conexiones.
     */
    public Controlador() {
        connectionManager = new ConnectionManager(this);
    }

    /**
     * Establece la conexión entre el modelo LWZ y los paneles de vista.
     * @param modelo Instancia de LWZ.
     * @param pnlText Panel de texto donde se mostrará el texto descomprimido.
     * @param pnlCodigo Panel donde se mostrará el código.
     */
    public void conectar(LWZ modelo, PnlTexto pnlText, PnlCodigo pnlCodigo) {
        this.modelo = modelo;
        this.pnlText = pnlText;
        this.pnlCodigo = pnlCodigo;
    }

    /**
     * Inicia el proceso de conexión y escucha de datos.
     */
    public void recibirYMostrar() {
        connectionManager.startListening();
    }

    /**
     * Procesa el código recibido, descomprimiéndolo y mostrando el resultado en la vista.
     * @param code Código comprimido a procesar.
     */
    public void procesarCodigo(Integer code) {
        String textoDescomprimido = modelo.decompress(code);
        pnlText.mostrarTexto(textoDescomprimido);
        pnlCodigo.agregarTexto(code);
    }
}
