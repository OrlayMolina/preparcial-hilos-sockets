package seguimiento.tallerhilos_sockets.abecedario;

import java.util.ArrayList;

public class Consumidor extends Thread{

    private Tuberia tuberia;

    public Consumidor( Tuberia t )
    {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
    }

    public void run() {
        char c;

        // Consume 26 letras de la tuber�a
        for( int i=0; i < 13; i++ )
        {
            c = tuberia.recoger();
            System.out.println( "Recogido el caracter "+c );

            c = tuberia.recoger();
            System.out.println( "Recogido el caracter "+c );

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
}
