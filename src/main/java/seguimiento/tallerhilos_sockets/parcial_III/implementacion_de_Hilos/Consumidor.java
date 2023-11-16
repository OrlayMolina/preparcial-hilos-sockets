package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Hilos;

import java.io.IOException;
import java.util.ArrayList;

public class Consumidor extends Thread{

    private Buffer buffer;
    private String palabra;
    private long delay;
    private ArrayList<Character> letrasDesechadas;

    public Consumidor(Buffer buffer, String palabra, long delay) {
        this.buffer = buffer;
        this.palabra = palabra;
        this.delay = delay;
        this.letrasDesechadas = new ArrayList();
    }

    public void run() {
        char[] result = new char[this.palabra.length()];


        ArrayList<Integer> posicionesUtilizadas = new ArrayList<>();



        while(this.arregloLleno(result)) {


            char letra = this.buffer.recoger();

            boolean letraEncontrada = false;


            for(int i = 0; i < this.palabra.length() && !letraEncontrada ; ++i) {
                if (this.palabra.charAt(i) == letra && !posicionesUtilizadas.contains(i)) {
                    posicionesUtilizadas.add(i);
                    result[i] = letra;
                    letraEncontrada = true;
                    System.out.println("Se consumio el carater " + letra);
                    System.out.println("Palabra formada: " + String.valueOf(result));


                }


            }

            if (!letraEncontrada) {
                this.letrasDesechadas.add(letra);
                System.out.println("Este caracter no sirve " + letra);
            }

            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException var6) {
                var6.printStackTrace();
            }
        }

        System.out.println("Palabra formada: " + String.valueOf(result));
        System.out.println("Letras no utilizadas: " + this.letrasDesechadas.toString());

    }

    public boolean arregloLleno(char[] arreglo) {
        char[] var2 = arreglo;
        int var3 = arreglo.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            char elemento = var2[var4];
            if (elemento == 0) {
                return true;
            }
        }

        return false;
    }
}
