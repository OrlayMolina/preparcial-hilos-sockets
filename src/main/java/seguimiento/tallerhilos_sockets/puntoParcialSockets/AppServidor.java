package seguimiento.tallerhilos_sockets.puntoParcialSockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AppServidor {

    public static final String RUTA_ARCHIVO_ESTUDIANTES = "src/main/resources/seguimiento/tallerhilos_sockets/archivos/estudiantes.txt";
    String host = "localhost";
    int puerto = 8081;
    ServerSocket server;

    Socket socketComunicacion;

    DataOutputStream flujoSalida;
    DataInputStream flujoEntrada;
    BufferedReader entrada;

    String mensajeCliente;

    public AppServidor() {
        // TODO Auto-generated constructor stub
    }

    public void iniciarServidor() {

        try {
            server = new ServerSocket(puerto);
            while(true)
            {
                System.out.println("Esperando al cliente");
                socketComunicacion = server.accept();

                flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());
                flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());

                enviarDatosPrimitivos();

                System.out.println("Recibiendo datos del cliente");
                recibirDatosPrimitivos();


                flujoEntrada.close();
                flujoSalida.close();
                socketComunicacion.close();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    private String recibirDatosPrimitivos() throws IOException {
        mensajeCliente = flujoEntrada.readUTF();
        System.out.println("Mensaje recibido del cliente: " + mensajeCliente); // Agregamos esta línea para imprimir el mensaje recibido
        return mensajeCliente;
    }


    private void enviarDatosPrimitivos() throws IOException {
        String mensajeRecibido = recibirDatosPrimitivos();
        flujoSalida.writeUTF("Cadena de texto recibida exitosamente! y guardada en el archivo Estudiante.txt");
        flujoSalida.writeUTF("Cadena recibida: " + mensajeRecibido);
    }

    public void guardarDatos(String ruta, String contenido, boolean b) throws IOException {
        FileWriter fw = new FileWriter(ruta, b);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido);
        bfw.close();
        fw.close();
    }
}
