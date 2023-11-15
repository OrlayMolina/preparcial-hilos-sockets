package seguimiento.tallerhilos_sockets.otroEjemploSockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AppCliente {

    String host;
    int puerto;
    Socket socketComunicador=new Socket();
    DataInputStream entradaCifras;
    DataInputStream entradaCadena;
    DataOutputStream salidaCifras;
    DataOutputStream salidaCadena;

    public AppCliente(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    public void iniciarcliente() throws IOException {

    }

    private void recibirObjeto() throws IOException {

    }

    private void mandarObjeto() throws IOException {
        
    }

    public void crearConexion() throws IOException {
        socketComunicador=new Socket(host,puerto);
    }

}
