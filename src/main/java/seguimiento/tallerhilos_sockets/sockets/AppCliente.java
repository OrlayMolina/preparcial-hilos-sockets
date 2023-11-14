package seguimiento.tallerhilos_sockets.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class AppCliente {


    String host;
    int puerto;
    Socket socketComunicacion;
    DataOutputStream flujoSalida;
    DataInputStream flujoEntrada;

    DataOutputStream flujoSalidaDos;
    DataInputStream flujoEntradaDos;


    public AppCliente(String host, int puerto) {
        this.puerto = puerto;
        this.host = host;
    }



    public void iniciarCliente() {


        try {
            crearConexion();

            flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
            flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());

            recibirDatosPrimitivos();


            flujoEntrada.close();
            flujoSalida.close();
            socketComunicacion.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    private void recibirDatosPrimitivos() throws IOException {
        String palabra = String.valueOf(flujoEntradaDos.read());

        System.out.println("Datos recibidos del servidor: "+flujoEntrada.readInt());
        System.out.println("Datos recibidos del servidor: "+flujoEntrada.readUTF());
    }



    private void crearConexion() throws IOException {
        socketComunicacion = new Socket(host, puerto);
    }




}
