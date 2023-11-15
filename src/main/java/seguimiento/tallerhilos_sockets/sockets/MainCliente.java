package seguimiento.tallerhilos_sockets.sockets;

import java.io.IOException;

public class MainCliente {

    public static void main(String[] args) throws IOException {
        AppCliente appCliente = new AppCliente("localhost", 8081);
        appCliente.iniciarcliente();
    }
}
