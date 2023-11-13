package seguimiento.tallerhilos_sockets.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class AppCliente {
    String host;
    int puerto;
    Socket socketComunicacion;
    ObjectInputStream flujoEntradaObjeto;

    public AppCliente(String host, int puerto) {
        this.puerto = puerto;
        this.host = host;
    }

    public void iniciarCliente() {


        try {
            crearConexion();

            flujoEntradaObjeto = new ObjectInputStream(socketComunicacion.getInputStream());


            flujoEntradaObjeto.close();
            socketComunicacion.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void crearConexion() throws IOException {
        // TODO Auto-generated method stub
        socketComunicacion = new Socket(host,puerto);

    }
}
