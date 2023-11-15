package seguimiento.tallerhilos_sockets.otroEjemploSockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {

    // el servidor no necesita el localhots pero si o si el puerto
    int puerto=8081;
    ServerSocket serverSocket;
    Socket socketComunicador;
    DataInputStream flujoEntradaDos;
    DataInputStream flujoEntradaUno;
    DataOutputStream flujoSalidaUno;
    DataOutputStream flujSalidaDos;
    String palabra;
    int numero;

    String respuestaPalabra;
    int respuestaDigitoDos;

    public void iniciarServidor() throws IOException {
        System.out.println("Esperando cliente");
        serverSocket=new ServerSocket(puerto);//ser crea el serve

        socketComunicador=serverSocket.accept();// espera para recibir el cliente
        flujoEntradaUno=new DataInputStream(socketComunicador.getInputStream());
        flujoEntradaDos=new DataInputStream(socketComunicador.getInputStream());
        flujoSalidaUno=new DataOutputStream(socketComunicador.getOutputStream());
        flujSalidaDos=new DataOutputStream(socketComunicador.getOutputStream());
        recibir();
        int vocales = contarVocales(palabra,0,0);
        int consonantes = contarConsonantes(palabra);
        respuestaPalabra= "La palabra tiene " + vocales +" vocales y "+ consonantes + " consonantes.";
        respuestaDigitoDos=contarCifras(numero,0);

        mandar();
        flujoSalidaUno.close();
        flujSalidaDos.close();
        flujoEntradaUno.close();
        flujoEntradaDos.close();
        socketComunicador.close();




    }

    private void mandar() throws IOException {
        flujoSalidaUno.write(respuestaPalabra.getBytes());
        flujSalidaDos.write(respuestaDigitoDos);
        System.out.println("mandado numero vocales servidor "+respuestaPalabra);
        System.out.println("mandado numero de digitos servidor "+respuestaDigitoDos);
    }

    private void recibir() throws IOException {
        palabra=flujoEntradaUno.readUTF();
        numero= flujoEntradaDos.readInt();
        System.out.println("recibio palabra servidor "+palabra.toLowerCase().trim());
        System.out.println("recibo numero servidior "+numero);

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

    public static int contarConsonantes(String cadena) {
        // Caso base: cadena vacía
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

    public int contarCifras(int numero,int contador){
        if(numero<1){
            return contador;
        }
        return contarCifras(numero/10,contador+1);
    }
}
