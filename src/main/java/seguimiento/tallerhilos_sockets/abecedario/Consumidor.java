package seguimiento.tallerhilos_sockets.abecedario;

public class Consumidor extends Thread{

    private Tuberia tuberia;

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
            c = tuberia.recoger();
            // Imprime las letras retiradas
            System.out.println( "Recogido el caracter "+c );
            // Espera un poco antes de coger m�s letras
            try
            {
                sleep( (int)(Math.random() * 2000 ) );
            }
            catch( InterruptedException e )
            {
                ;
            }
        }
    }
}
