package seguimiento.tallerhilos_sockets.otroEjemploSockets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {

    String host = "localhost";
    int puerto = 8081;
    ServerSocket server;
    Socket socketComunicacion;

    //entradaCifras y salidaCifras se usará para comunicar la cantidad de cifras de un número.
    DataInputStream entradaCifras;
    DataOutputStream salidaCifras;

    //entradaCadena y salidaCadena se usará para comunicar la cantidad de vocales y consonantes.
    DataInputStream entradaCadena;
    DataOutputStream salidaCadena;

    static int vocales = 0;
    static int consonantes = 0;
    static String cadenaCliente;
    static String respuestaCadenaServidor;

    static int numero;

    public AppServidor() {
        // TODO Auto-generated constructor stub
    }

    public void iniciarServidor() throws IOException {

        try {
            server = new ServerSocket(puerto);
            while(true) {

                System.out.println("Esperando al cliente\n");
                socketComunicacion = server.accept();

                salidaCifras = new DataOutputStream(socketComunicacion.getOutputStream());
                entradaCifras = new DataInputStream(socketComunicacion.getInputStream());

                salidaCadena = new DataOutputStream(socketComunicacion.getOutputStream());
                entradaCadena = new DataInputStream(socketComunicacion.getInputStream());

                recibirDatos();

                mandarDatos();

                entradaCadena.close();
                salidaCadena.close();
                entradaCifras.close();
                salidaCifras.close();
                socketComunicacion.close();

            }

        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void recibirDatos() throws IOException {

        numero = entradaCifras.readInt();
        System.out.println("Número que envió el cliente: " + numero);

        cadenaCliente = entradaCadena.readUTF();
        System.out.println("Palabra que envió el cliente: " + cadenaCliente +"\n");
        System.out.println("Generando resultados...\n");
    }

    private void mandarDatos() throws IOException {

        int cifras = calcularCifras(numero);
        salidaCifras.writeInt(cifras);
        System.out.println("Enviando el número de cifras del número recibido: "+ cifras);
        System.out.println("Enviando respuesta de vocales y consonantes al cliente... \n");
        salidaCadena.writeUTF(respuestaCadena());
    }

    private static int calcularCifras(int n) {

        if(n < 10){
            return 1;
        }else {
            n = n/10;
            return calcularCifras(n)+1;
        }
    }

    private static String respuestaCadena(){

        vocales = contarVocales(cadenaCliente, 0, 0);
        consonantes = contarConsonantes(cadenaCliente);

        respuestaCadenaServidor = "La palabra tiene " + vocales + " vocales y " + consonantes + " consonates.";
        return respuestaCadenaServidor;
    }

    public static int contarVocales(String palabra, int indice, int contador){
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

    public static int contarConsonantes(String cadena) {
        if (cadena.equals("")) {
            return 0;
        } else {
            char primerCaracter = cadena.charAt(0);
            if (esConsonate(primerCaracter)) {
                return 1 + contarConsonantes(cadena.substring(1));
            } else {
                return contarConsonantes(cadena.substring(1));
            }
        }
    }
    private static boolean esConsonate(char c) {
        if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' ){
            return true;
        }else{
            return false;
        }
    }

}
