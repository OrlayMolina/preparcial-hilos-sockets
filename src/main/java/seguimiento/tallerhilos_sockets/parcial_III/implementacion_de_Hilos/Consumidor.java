package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Hilos;

import java.io.IOException;
import java.util.ArrayList;

public class Consumidor extends Thread{

    Main main = new Main();
    private Buffer buffer;
    private String palabra;
    private ArrayList<Character> letrasDesechadas;

    public Consumidor(Buffer buffer, String palabra, ArrayList<Character> letrasDesechadas) {
        this.buffer = buffer;
        this.palabra = palabra;
        this.letrasDesechadas = letrasDesechadas;
    }

    @Override
    public void run() {
        char[] result = new char[this.palabra.length()];
        ArrayList<Integer> posicionesUtilizadas = new ArrayList<>();

        int caracteresConsumidos = 0; // Contador para llevar el seguimiento de los caracteres consumidos en cada iteración

        while (this.arregloLleno(result)) {
            char letra1 = this.buffer.recoger(); // Recoger el primer carácter
            char letra2 = this.buffer.recoger(); // Recoger el segundo carácter

            boolean letra1Encontrada = false;
            boolean letra2Encontrada = false;

            for (int i = 0; i < this.palabra.length() && (caracteresConsumidos < 2); ++i) {
                if (this.palabra.charAt(i) == letra1 && !posicionesUtilizadas.contains(i)) {
                    posicionesUtilizadas.add(i);
                    result[i] = letra1;
                    letra1Encontrada = true;
                    caracteresConsumidos++;
                    System.out.println("Se consumió el carácter " + letra1 + " para la posición " + i);
                    System.out.println("Palabra formada: " + String.valueOf(result));
                } else if (this.palabra.charAt(i) == letra2 && !posicionesUtilizadas.contains(i)) {
                    posicionesUtilizadas.add(i);
                    result[i] = letra2;
                    letra2Encontrada = true;
                    caracteresConsumidos++;
                    System.out.println("Se consumió el carácter " + letra2 + " para la posición " + i);
                    System.out.println("Palabra formada: " + String.valueOf(result));
                }
            }

            if (!letra1Encontrada) {
                if(main.buscarElemento(letrasDesechadas,0,letrasDesechadas.size()-1,letra1)){
                    this.letrasDesechadas.add(letra1);
                    System.out.println("El carácter " + letra1 + " no se puede utilizar.");
                }
            }

            if (!letra2Encontrada) {
                if (main.buscarElemento(letrasDesechadas,0,letrasDesechadas.size()-1,letra2)){
                    this.letrasDesechadas.add(letra2);
                    System.out.println("El carácter " + letra2 + " no se puede utilizar.");
                }
            }

            caracteresConsumidos = 0; // Reiniciar el contador para la siguiente iteración

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Palabra formada: " + String.valueOf(result));
        System.out.println("Letras no utilizadas: " + this.letrasDesechadas.toString());
    }


    public boolean arregloLleno(char[] arreglo) {

        for (char elemento : arreglo) {
            if (elemento == 0) {
                return true;
            }
        }

        return false;
    }
}
