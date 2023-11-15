package seguimiento.tallerhilos_sockets.puntoParcialSockets;

import java.io.IOException;

public class MainServidor {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        AppServidor appServidor = new AppServidor();
        appServidor.iniciarServidor();
        appServidor.guardarDatos(AppServidor.RUTA_ARCHIVO_ESTUDIANTES,appServidor.mensajeCliente, false);
    }
}
