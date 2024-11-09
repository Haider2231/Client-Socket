package controlador;

import java.io.ObjectInputStream;
import java.net.Socket;
import mundo.LWZ;
import vista.pnlCodigo;
import vista.pnlTexto;


public class Controlador {

    private LWZ modelo;
    private pnlTexto pnlText;
    private pnlCodigo pnlcodigo;

    public Controlador() {
       
    }

    
    
    public void  Conectar (LWZ modelo, pnlTexto pnlText,pnlCodigo pnlcodigo) {
        this.modelo = modelo;
        this.pnlText = pnlText;
        this.pnlcodigo= pnlcodigo;
    }

   
    
    // Método para conectarse al servidor y recibir datos comprimidos
    public void recibirYMostrarTextoDescomprimido() {
        try (Socket socketToServer = new Socket("192.168.20.52", 5000);
             ObjectInputStream in = new ObjectInputStream(socketToServer.getInputStream())) {

            while (true) {
                try {
                    Integer code = (Integer) in.readObject(); // Leer un código comprimido
                    if (code != null) {
                        String textoDescomprimido = modelo.decompress(code); // Descomprimir
                        pnlText.mostrarTexto(textoDescomprimido); // Mostrar en la vista
                        Thread.sleep(1000); 
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void recibirYMostrarCodigo() {
    try (Socket socketToServer = new Socket("192.168.20.52", 5000);
         ObjectInputStream in = new ObjectInputStream(socketToServer.getInputStream())) {

        while (true) {
            try {
                Integer code = (Integer) in.readObject(); 
                if (code != null) {
                    pnlcodigo.agregarTexto(code); 
                    Thread.sleep(1000);
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
}
