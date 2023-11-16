package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Hilos;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String cadena = "abcdefghijklmnopqrstuvwxyz01234567890@#/%+:;";
        ArrayList<Character> listaPalabrasNoUsadas = new ArrayList<>();
        Buffer buffer = new Buffer();
        Productor1 p1 = new Productor1(buffer, cadena, listaPalabrasNoUsadas);
        Productor2 p2 = new Productor2(buffer, cadena, listaPalabrasNoUsadas);
        Productor3 p3 = new Productor3(buffer, cadena, listaPalabrasNoUsadas);
        Productor4 p4 = new Productor4(buffer, cadena, listaPalabrasNoUsadas);
        Consumidor consumidor = new Consumidor(buffer, "universid@d#2023%", listaPalabrasNoUsadas);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        consumidor.start();

        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
            consumidor.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
