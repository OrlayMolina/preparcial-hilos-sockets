package seguimiento.tallerhilos_sockets.buscarPalabra;

public class MainBuscarPalabra {

    public static void main(String[] args) {

        HiloBusqueda1 hilo1 = new HiloBusqueda1("crud","C:\\Java proyectos");
        HiloBusqueda2 hilo2 = new HiloBusqueda2("tarea", "C:\\Java proyectos");
        hilo1.start();
        hilo2.start();

    }
}
