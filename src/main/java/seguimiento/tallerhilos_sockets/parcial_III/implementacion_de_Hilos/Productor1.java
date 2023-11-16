package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Hilos;

import java.util.ArrayList;

public class Productor1 extends Thread{
    Main main = new Main();
    private Buffer buffer;
    private String arreglo;
    private ArrayList<Character> vocalNoUsada = new ArrayList<>();

    public Productor1(Buffer buffer, String arreglo, ArrayList<Character> vocalNoUsada) {
        this.buffer = buffer;
        this.arreglo = arreglo;
        this.vocalNoUsada = vocalNoUsada;
    }

    @Override
    public void run() {

        char c;

        for( int i=0; i < 10; i++ )
        {
            c = arreglo.charAt( (int)(Math.random()*44 ) );
            if(determinarVocales(c)){
                buffer.lanzar( c );
                System.out.println( "Lanzado "+c+" al buffer." );
            }else {
                if(main.buscarElemento(vocalNoUsada, 0, vocalNoUsada.size()-1, c)){
                    vocalNoUsada.add(c);
                }
            }

            try
            {
                sleep( 100  );
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }
        }
    }

    public static boolean determinarVocales(char letra){

        if(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u'){
            return true;
        }else{
            return false;
        }
    }
}
