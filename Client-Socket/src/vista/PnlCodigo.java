package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * PnlCodigo representa el panel donde se muestra el código comprimido
 * recibido desde el servidor.
 */
public class PnlCodigo extends JPanel {

    private JTextField textField;

    /**
     * Constructor de PnlCodigo.
     * Configura el campo de texto donde se mostrará el código recibido.
     */
    public PnlCodigo() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(255, 255, 255, 240));

        textField = new JTextField(15);
        textField.setEditable(false);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 50), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        add(textField);
    }

    /**
     * Muestra el código recibido en el campo de texto.
     * @param code Código a mostrar.
     */
    public void agregarTexto(Integer code) {
        textField.setText(code.toString());
    }
}
