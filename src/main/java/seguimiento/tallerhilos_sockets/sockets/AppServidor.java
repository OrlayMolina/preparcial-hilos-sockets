package seguimiento.tallerhilos_sockets.sockets;

import java.io.*;
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

    int respuestaDigitoUno;
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

        respuestaDigitoUno=contarVocales(palabra,0,0);
        respuestaDigitoDos=contarCifras(numero,0);

        mandar();
        flujoSalidaUno.close();
        flujSalidaDos.close();
        flujoEntradaUno.close();
        flujoEntradaDos.close();
        socketComunicador.close();




    }

    private void mandar() throws IOException {
        flujoSalidaUno.write(respuestaDigitoUno);
        flujSalidaDos.write(respuestaDigitoDos);
        System.out.println("mandado numero vocales servidor "+respuestaDigitoUno);
        System.out.println("mandado numero de digitos servidor "+respuestaDigitoDos);
    }

    private void recibir() throws IOException {
        palabra=flujoEntradaUno.readUTF();
        numero= flujoEntradaDos.readInt();
        System.out.println("recibio palabra servidor "+palabra);
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

    public int contarCifras(int numero,int contador){
        if(numero<1){
            return contador;
        }
        return contarCifras(numero/10,contador+1);
    }
}
