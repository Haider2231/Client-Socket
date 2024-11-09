package vista;

import controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import mundo.LWZ;

public class ventanaPrincipal extends JFrame {

    private pnlTexto pnlTexto;
    private pnlCodigo pnlCodigo;
    private Controlador ctrl;
    private LWZ lwz;

    public ventanaPrincipal() {
        setTitle("Cliente");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setBackground(new Color(240, 240, 240));

        pnlTexto = new pnlTexto();
        pnlCodigo = new pnlCodigo();

        lwz = new LWZ();
        ctrl = new Controlador();

        add(pnlCodigo, BorderLayout.NORTH);
        add(pnlTexto, BorderLayout.CENTER);

        ctrl.Conectar(lwz, pnlTexto,pnlCodigo);
        
        setVisible(true);

       ctrl.recibirYMostrar(); 
    }

    public static void main(String[] args) {
        new ventanaPrincipal();
    }
}
