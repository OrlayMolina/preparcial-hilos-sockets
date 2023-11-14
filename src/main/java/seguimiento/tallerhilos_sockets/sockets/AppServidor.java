package seguimiento.tallerhilos_sockets.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {


    String host = "localhost";
    int puerto = 8081;
    ServerSocket server;

    int numero = 46685545;
    Socket socketComunicacion;

    DataOutputStream flujoSalida;
    DataInputStream flujoEntrada;
    BufferedReader entrada;

    String palabra = "Jose";
    int numeroVocales;
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
                numeroVocales = contarVocales(palabra, 0, 0);

                flujoEntrada.close();
                flujoSalida.close();
                socketComunicacion.close();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    private void enviarDatosPrimitivos() throws IOException {

        int entero = calcularCifras(numero);

        flujoSalida.writeInt(entero);
        System.out.println("Enviando entero:"+ entero);

        flujoSalida.writeUTF("Enviando hola");
        System.out.println("Se envio hola");
    }

    private static int calcularCifras(int n) {

        if(n < 10){
            return 1;
        }else {
            n = n/10;
            return calcularCifras(n)+1;
        }
    }

    public int contarVocales(String palabra, int indice,int contador){
        if(indice>=palabra.length()){
            return contador;
        }
        if(String.valueOf(palabra.charAt(indice)).equals("a") || String.valueOf(palabra.charAt(indice)).equals("e") ||
                String.valueOf(palabra.charAt(indice)).equals("i") || String.valueOf(palabra.charAt(indice)).equals("o")
                || String.valueOf(palabra.charAt(indice)).equals("u")){
            contador=contador+1;
            contarVocales(palabra,indice+1,contador);
        }
        return contarVocales(palabra,indice+1,contador);
    }

}
