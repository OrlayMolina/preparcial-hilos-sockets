package seguimiento.tallerhilos_sockets.abecedario;

import java.util.ArrayList;

public class Productor1 extends Thread {

    Tuberia tuberia;


    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private ArrayList<Character> listaLetras = obtenerLista();

    public Productor1( Tuberia t )
    {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
    }

    public void run() {
        char c;

        // Cada productor podria meter un maximo de 13 letras a la tuberia
        for( int i=0; i < 13; i++ )
        {
            c = alfabeto.charAt( (int)(Math.random()*26 ) );

            if(!buscarElemento(listaLetras, 0, listaLetras.size()-1, c)){
                listaLetras.add(c);
                agregarLetra(listaLetras);
                tuberia.lanzar( c );
            }

            // Imprime un registro con lo a�adido
            System.out.println( "Productor 1 Lanzó "+c+" a la tuberia." );
            // Espera un poco antes de añadir más letras
            try
            {
                sleep( 1000 );
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }
        }
    }

    private static boolean buscarElemento(ArrayList<Character> array, int inicial, int fin, Character numeroBuscado) {

        if(inicial > fin){
            return false;
        }else {
            if(array.get(inicial).equals(numeroBuscado)){
                return true;
            }else {
                return buscarElemento(array, inicial+1, fin, numeroBuscado);
            }
        }
    }

    public ArrayList<Character> obtenerLista(){
        return tuberia.getLetrasConsumidas();
    }

    public void agregarLetra(ArrayList<Character> listaLetras){
        tuberia.setLetrasConsumidas(listaLetras);
    }
}
