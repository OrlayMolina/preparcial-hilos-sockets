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
    DataInputStream entradaCifras;
    DataInputStream entradaCadena;
    DataOutputStream salidaCifras;
    DataOutputStream salidaCadena;

    String mensajeCliente;

    public AppServidor() {
        // TODO Auto-generated constructor stub
    }

    public void iniciarServidor() throws IOException {

    }

    private void mandarDatos() throws IOException {

    }

    private void recibirDatos() throws IOException {

    }

    private static int calcularCifras(int n) {

        if(n < 10){
            return 1;
        }else {
            n = n/10;
            return calcularCifras(n)+1;
        }
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
