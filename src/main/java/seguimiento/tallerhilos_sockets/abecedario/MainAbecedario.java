package seguimiento.tallerhilos_sockets.abecedario;

public class MainAbecedario {

    public static void main(String[] args) {
        Tuberia t = new Tuberia();
        Productor1 p1 = new Productor1( t );
        Productor2 p2 = new Productor2( t );
        Consumidor c = new Consumidor( t );
        p1.start();
        p2.start();
        c.start();
    }
}
