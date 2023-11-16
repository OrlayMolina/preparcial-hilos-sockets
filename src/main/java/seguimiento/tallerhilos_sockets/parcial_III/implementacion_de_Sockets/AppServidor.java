package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {

    public static final String RUTA_ARCHIVO_TANQUEO = "src/main/resources/seguimiento/tallerhilos_sockets/archivos/tanqueo.txt";
    String host = "localhost";
    int puerto = 8081;
    ServerSocket server;
    Socket socketComunicacion;
    static DataOutputStream respuestaGenerada;
    DataInputStream infoCliente;

    String mensajeCliente;

    public AppServidor(int puerto) {

    }

    public void iniciarServidor() {
        try {
            server = new ServerSocket(puerto);
            while(true) {

                System.out.println("Esperando información del cliente...\n");
                socketComunicacion = server.accept();

                respuestaGenerada = new DataOutputStream(socketComunicacion.getOutputStream());
                infoCliente = new DataInputStream(socketComunicacion.getInputStream());

                recibirDatos();

                enviarRespuesta();

                infoCliente.close();
                respuestaGenerada.close();
                socketComunicacion.close();

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void recibirDatos() throws IOException {
        mensajeCliente = infoCliente.readUTF();
        System.out.println("Mensaje recibido del cliente: " + mensajeCliente); // Agregamos esta línea para imprimir el mensaje recibido
        guardarDatos(RUTA_ARCHIVO_TANQUEO, mensajeCliente,true);
    }

    private static void enviarRespuesta() throws IOException {

        respuestaGenerada.writeUTF("Información recibida exitosamente!, se ha guardado en el archivo tanqueo.txt");

    }

    public void guardarDatos(String ruta, String contenido, boolean b) throws IOException {
        FileWriter fw = new FileWriter(ruta, b);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido+"\n");
        bfw.close();
        fw.close();
    }

}
