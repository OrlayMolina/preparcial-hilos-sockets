package seguimiento.tallerhilos_sockets.abecedario;

import java.util.ArrayList;

public class MainAbecedario {
    static ArrayList<Character> letrasRecogidas = new ArrayList<>();
    static int contarLanzadas = 0;

    public static void main(String[] args) {
        Tuberia t = new Tuberia();
        Productor1 p1 = new Productor1( t );
        Productor2 p2 = new Productor2( t );
        Consumidor c = new Consumidor( t );
        p1.start();
        p2.start();
        c.start();
    }

    public boolean buscarElemento(ArrayList<Character> letrasRecogidas, int inicial, int fin, int numeroBuscado) {

        if(inicial > fin){
            return true;
        }else {
            if(letrasRecogidas.get(inicial) == numeroBuscado){
                return false;
            }else {
                return buscarElemento(letrasRecogidas, inicial+1, fin, numeroBuscado);
            }
        }
    }

}
