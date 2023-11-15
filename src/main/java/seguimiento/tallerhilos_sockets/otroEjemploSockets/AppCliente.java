package seguimiento.tallerhilos_sockets.otroEjemploSockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AppCliente {

    String host;
    int puerto;
    Socket socketComunicador = new Socket();
    DataInputStream entradaCifras;
    DataInputStream entradaCadena;
    DataOutputStream salidaCifras;
    DataOutputStream salidaCadena;

    public AppCliente(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    public void iniciarCliente() throws IOException {

        try {
            crearConexion();

            entradaCadena = new DataInputStream(socketComunicador.getInputStream());
            salidaCadena = new DataOutputStream(socketComunicador.getOutputStream());

            mandarDatos();
            System.out.println("Enviando datos al servidor");
            recibirDatos();


            entradaCadena.close();
            salidaCadena.close();
            socketComunicador.close();

        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void mandarDatos() throws IOException {
        salidaCadena.writeUTF("Gerontologia");
    }

    private void recibirDatos() throws IOException {
        System.out.println("Datos recibidos del servidor: "+entradaCadena.readUTF());
    }

    public void crearConexion() throws IOException {
        socketComunicador=new Socket(host,puerto);
    }

}
