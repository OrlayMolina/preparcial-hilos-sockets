package seguimiento.tallerhilos_sockets.abecedario;

import java.util.ArrayList;

public class Consumidor extends Thread{

    private Tuberia tuberia;

    private ArrayList<String> letrasConsumidas = new ArrayList<>();

    public Consumidor( Tuberia t )
    {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
    }

    public void run() {
        char c;

        // Consume 15 letras de la tuber�a
        for( int i=0; i < 15; i=i+2 )
        {
            c = tuberia.recoger();
            // Imprime las letras retiradas
            System.out.println( "Recogido el caracter "+c );
            letrasConsumidas.add(String.valueOf(c));

            c = tuberia.recoger();

            if (!buscarElemento(letrasConsumidas, 0, letrasConsumidas.size()-1, String.valueOf(c))){

                System.out.println( "Recogido el caracter "+c );
                letrasConsumidas.add(String.valueOf(c));
            }else {
                c = tuberia.recoger();
            }
            // Espera un poco antes de coger m�s letras
            try
            {
                sleep( 3000 );
            }
            catch( InterruptedException e )
            {
                ;
            }
        }
    }

    private static boolean buscarElemento(ArrayList<String> array, int inicial, int fin, String numeroBuscado) {

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
}
