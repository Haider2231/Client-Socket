package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * PnlTexto representa el área de texto de la interfaz donde se muestra 
 * el texto recibido y descomprimido del servidor.
 */
public class PnlTexto extends JPanel {
    
    private JTextArea textArea;

    /**
     * Constructor de PnlTexto.
     * Configura el área de texto y el panel de desplazamiento.
     */
    public PnlTexto() {
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255, 240));

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 50), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        add(scrollPane, BorderLayout.CENTER);
    }
    
    /**
     * Muestra el texto recibido en el área de texto.
     * @param texto Texto a mostrar.
     */
    public void mostrarTexto(String texto) {
        textArea.append(texto);
    }
}
