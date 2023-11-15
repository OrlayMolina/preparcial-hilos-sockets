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

            //Ejercicio a, contar las cifras de un número
            entradaCifras = new DataInputStream(socketComunicador.getInputStream());
            salidaCifras = new DataOutputStream(socketComunicador.getOutputStream());

            //Ejercicio b, contar vocales y consonantes de una cadena
            entradaCadena = new DataInputStream(socketComunicador.getInputStream());
            salidaCadena = new DataOutputStream(socketComunicador.getOutputStream());

            mandarDatos();

            recibirDatos();

            entradaCadena.close();
            salidaCadena.close();
            entradaCifras.close();
            salidaCifras.close();
            socketComunicador.close();

        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void mandarDatos() throws IOException {
        System.out.println("Enviado número al servidor...");
        salidaCifras.writeInt(54886);
        System.out.println("Enviando cadena al servidor...\n");
        salidaCadena.writeUTF("Gerontologia");
    }

    private void recibirDatos() throws IOException {
        System.out.println("Datos recibidos del servidor, número de cifras del número enviado: "+entradaCifras.readInt());
        System.out.println("Datos recibidos del servidor, cantidad de vocales y consonantes de la cadena enviada: "+entradaCadena.readUTF());
    }

    public void crearConexion() throws IOException {
        socketComunicador=new Socket(host,puerto);
    }

}
