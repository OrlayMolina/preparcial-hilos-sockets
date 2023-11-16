package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Hilos;

import java.util.ArrayList;

public class Productor3 extends Thread{
    Main main = new Main();
    private Buffer buffer;
    private String arreglo;
    private final ArrayList<Character> numeroNoUsado;

    public Productor3(Buffer buffer, String arreglo, ArrayList<Character> numeroNoUsado) {
        this.buffer = buffer;
        this.arreglo = arreglo;
        this.numeroNoUsado = numeroNoUsado;
    }

    @Override
    public void run() {
        char c;
        while(true)
        {
            c = arreglo.charAt( (int)(Math.random()*44 ) );
            if(determinarNumero(c)){
                buffer.lanzar( c );
                System.out.println( "Lanzado el número "+c+" al buffer" );
            }else {
                if(main.buscarElemento(numeroNoUsado, 0, numeroNoUsado.size()-1, c)){
                    numeroNoUsado.add(c);
                }
            }

            try
            {
                sleep( 250 );
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }
        }
    }

    public static boolean determinarNumero(char numero){

        if(numero == '0' || numero == '1' || numero == '2' || numero == '3' ||
                numero == '4' || numero == '5' || numero == '6' || numero == '7' ||
                numero == '8' || numero == '9'){
            return true;
        }else{
            return false;
        }
    }
}
