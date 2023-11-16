package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Sockets;

public class MainServidor {
    public static void main(String[] args) {
        AppServidor appServidor = new AppServidor(8081);
        appServidor.iniciarServidor();
    }
}
