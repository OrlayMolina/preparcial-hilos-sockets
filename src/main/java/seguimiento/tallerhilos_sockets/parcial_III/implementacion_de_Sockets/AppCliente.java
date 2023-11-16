package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Sockets;

import java.io.*;
import java.net.Socket;

public class AppCliente {

    String host;
    int puerto;

    String infoVehiculo;
    Socket socketComunicador = new Socket();
    DataInputStream entradaRespuesta;
    DataOutputStream salidaInfo;

    public AppCliente(String host, int puerto, String vehiculo) {
        this.host = host;
        this.puerto = puerto;
        infoVehiculo = vehiculo;
    }

    public void iniciarCliente() throws IOException {
        try {
            crearConexion();

            entradaRespuesta = new DataInputStream(socketComunicador.getInputStream());
            salidaInfo = new DataOutputStream(socketComunicador.getOutputStream());

            System.out.println("Recibiendo respuesta del servidor...\n");
            recibirDatosRespuesta();

            System.out.println("Enviando datos al servidor");


            entradaRespuesta.close();
            salidaInfo.close();
            socketComunicador.close();

        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void recibirDatosRespuesta() throws IOException {
        System.out.println("Respuesta del servidor: " + entradaRespuesta.readUTF());
    }


    public void crearConexion() throws IOException {
        socketComunicador=new Socket(host,puerto);
    }
}
