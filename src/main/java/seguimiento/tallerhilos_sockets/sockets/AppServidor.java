package seguimiento.tallerhilos_sockets.sockets;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {

    String host = "localhost";
    int puerto = 8081;
    ServerSocket server;

    Socket socketComunicacion;
    ObjectOutputStream flujoSalidaObjeto;
    String mensajeCliente;

    public AppServidor() {
        // TODO Auto-generated constructor stub
    }

    public void iniciarServidor() {

        try {
            server = new ServerSocket(puerto);

            System.out.println("Esperando cliente");
            socketComunicacion = server.accept();

            flujoSalidaObjeto = new ObjectOutputStream(socketComunicacion.getOutputStream());

            flujoSalidaObjeto.close();
            socketComunicacion.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
