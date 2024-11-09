/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author ASUS
 */
public class pnlTexto  extends JPanel{
    
     private JTextArea textArea;

    public pnlTexto() {
   
       setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255, 240)); // Fondo neumórfico

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrlChat = new JScrollPane(textArea);
        scrlChat.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 50), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        add(scrlChat, BorderLayout.CENTER);
    }
    
    public void mostrarTexto(String texto) {
        textArea.append(texto );
    }
     
}
