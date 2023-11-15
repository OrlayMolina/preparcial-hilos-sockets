package seguimiento.tallerhilos_sockets.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class AppCliente {
    String host;
    int puerto;
    Socket socketComunicador=new Socket();
    DataInputStream flujoEntradaUno;//flujo de entrada;              //cuando se va a mandar palabras o numeros se usa DataInputStream
    DataInputStream flujoEntradaDos;// flujo de entrada;             // cuando se va a mandar objeto se usa ObjectInput
    DataOutputStream flujoSalidaUno; //flujo de salida
    DataOutputStream flujoSalidaDos;//flujo de salida

    public AppCliente(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }
    public void iniciarcliente() throws IOException {
        crearConexio();
        flujoEntradaDos =new DataInputStream(socketComunicador.getInputStream());
        flujoEntradaUno =new DataInputStream(socketComunicador.getInputStream());
        flujoSalidaUno =new DataOutputStream(socketComunicador.getOutputStream());
        flujoSalidaDos =new DataOutputStream(socketComunicador.getOutputStream());
        mandarObjeto();

        recibirObjeto();

        flujoEntradaUno.close();
        flujoEntradaDos.close();
        flujoSalidaUno.close();
        flujoSalidaDos.close();
        socketComunicador.close();




    }

    private void recibirObjeto() throws IOException {
        String palabraUno=String.valueOf(flujoEntradaUno.read());
        String palabraDos= String.valueOf(flujoEntradaDos.read());
        System.out.println(" Recibir Numero vocales cliente "+palabraUno);
        System.out.println(" Recibir Numero de cifras cliente "+palabraDos);
    }

    private void mandarObjeto() throws IOException {
        flujoSalidaUno.writeUTF("hola");
        flujoSalidaDos.writeInt(5486);
        System.out.println("Mandar palabra cliente manda hola");
        System.out.println("Mandar numero cliente mandado 5486");
    }

    public void crearConexio() throws IOException {
        socketComunicador=new Socket(host,puerto);
    }
}
