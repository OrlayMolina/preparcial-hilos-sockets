package seguimiento.tallerhilos_sockets.otroEjemploSockets;

import java.io.IOException;

public class MainServidor {

    public static void main(String[] args) throws IOException {
        AppServidor appServidor = new AppServidor();
        appServidor.iniciarServidor();
    }
}
