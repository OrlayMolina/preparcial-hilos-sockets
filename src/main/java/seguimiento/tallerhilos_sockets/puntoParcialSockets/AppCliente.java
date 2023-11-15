package seguimiento.tallerhilos_sockets.puntoParcialSockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AppCliente {

    String host;
    int puerto;
    Socket socketComunicacion;
    DataOutputStream flujoSalida;
    DataInputStream flujoEntrada;


    public AppCliente(String host, int puerto) {
        this.puerto = puerto;
        this.host = host;
    }

    public void iniciarCliente() {

        try {

            crearConexion();

            flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
            flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());

            System.out.println("Enviando datos al servidor... Espere!");
            enviarDatosPrimitivos();

            recibirDatosPrimitivos();

            flujoEntrada.close();
            flujoSalida.close();
            socketComunicacion.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    private void enviarDatosPrimitivos() throws IOException {

        flujoSalida.writeUTF("1094952205;Orlay Andrés;Molina Gómez;28;Estudiante");
    }


    private void recibirDatosPrimitivos() throws IOException {

        System.out.println("Respuesta del servidor: "+flujoEntrada.readUTF());
    }



    private void crearConexion() throws IOException {
        socketComunicacion = new Socket(host, puerto);
    }
}
