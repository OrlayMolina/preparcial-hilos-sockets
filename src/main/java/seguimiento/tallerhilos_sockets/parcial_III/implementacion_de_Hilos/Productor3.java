package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Hilos;

import java.util.ArrayList;

public class Productor3 extends Thread{
    Main main = new Main();
    private Buffer buffer;
    private String arreglo;
    private ArrayList<Character> numeroNoUsado = new ArrayList<>();

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

    public static boolean determinarNumero(char letra){

        if(letra == '0' || letra == '1' || letra == '2' || letra == '3' ||
                letra == '4' || letra == '5' || letra == '6' || letra == '7' ||
                letra == '8' || letra == '9'){
            return true;
        }else{
            return false;
        }
    }
}
