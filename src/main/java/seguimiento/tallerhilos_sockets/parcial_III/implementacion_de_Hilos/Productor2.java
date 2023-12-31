package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Hilos;

import java.util.ArrayList;

public class Productor2 extends Thread{
    Main main = new Main();
    private Buffer buffer;
    private String arreglo;
    private final ArrayList<Character> consonanteNoUsada;

    public Productor2(Buffer buffer, String arreglo, ArrayList<Character> consonanteNoUsada) {
        this.buffer = buffer;
        this.arreglo = arreglo;
        this.consonanteNoUsada = consonanteNoUsada;
    }

    @Override
    public void run() {

        char c;

        while(true)
        {
            c = arreglo.charAt( (int)(Math.random()*44 ) );
            if(determinarConsonantes(c)){
                buffer.lanzar( c );
                System.out.println( "Lanzada la consonante "+c+" al buffer" );
            }else {
                if(main.buscarElemento(consonanteNoUsada, 0, consonanteNoUsada.size() - 1, c)){
                    consonanteNoUsada.add(c);
                }
            }

            try
            {
                sleep( 150 );
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }
        }

    }

    public static boolean determinarConsonantes(char letra) {

        if (esConsonate(letra)) {
            return true;
        } else {
            return false;
        }

    }
    private static boolean esConsonate(char c) {
        if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != '0' &&
                c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' &&
                c != '7' && c != '8' && c != '9' && c != '@' && c != '#' && c != '/' &&
                c != '%' && c != '+' && c != ':' && c != ';'){
            return true;
        }else{
            return false;
        }
    }
}
