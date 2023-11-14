package seguimiento.tallerhilos_sockets.imprimirUniquindio2023;

import java.util.ArrayList;

public class Consumidor extends Thread{

    String palabra="uniquindio2023";
    String palabraVacia="";
    int posicion=0;
    ArrayList<Character> incorrectos=new ArrayList<>();
    boolean arrancar=true;
    Tuberia tuberia;
    public Consumidor(Tuberia tuberia){
        this.tuberia=tuberia;
    }

    @Override
    public void run() {
        while (arrancar){
            char letraUno= tuberia.lanzarConsumidorUno();
            char letraDos= tuberia.lanzarConsumidoDos();
            System.out.println(palabraVacia);


            if(posicion>palabra.length()-1){
                arrancar=false;
            }
            try {


                char letra = palabra.charAt(posicion);
                if (letraUno == letra) {
                    System.out.println(palabra.charAt(posicion));
                    palabraVacia += letraUno;
                    posicion = posicion + 1;
                    System.out.println(palabraVacia);

                } else if (letraDos == letra) {
                    palabraVacia += letraDos;
                    posicion = posicion + 1;
                    System.out.println(palabraVacia);
                } else {
                    incorrectos.add(palabra.charAt(posicion));
                    System.out.println(palabraVacia);
                }
            } catch (Exception e) {
                System.out.print("termino con exito     ");
            }


        }
    }
}
