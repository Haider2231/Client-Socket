/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class pnlCodigo  extends JPanel {
    
      private JTextField textField;

    public pnlCodigo() {
   
         setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(255, 255, 255, 240)); // Fondo neumórfico

        textField = new JTextField(15);
        textField.setEditable(false);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 50), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));


        add(textField);
    }
       
       public void agregarTexto(Integer code) {
        textField.setText(code.toString());
    }
    
}
