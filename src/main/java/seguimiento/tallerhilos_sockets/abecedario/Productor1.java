package seguimiento.tallerhilos_sockets.abecedario;

public class Productor1 extends Thread {

    private Tuberia tuberia;
    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Productor1( Tuberia t )
    {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
    }

    public void run() {
        char c;

        // Mete 10 letras en la tubería
        for( int i=0; i < 10; i++ )
        {
            c = alfabeto.charAt( (int)(Math.random()*26 ) );
            tuberia.lanzar( c );
            // Imprime un registro con lo a�adido
            System.out.println( "Productor 1 Lanzó "+c+" a la tuberia." );
            // Espera un poco antes de añadir más letras
            try
            {
                sleep( (int)(Math.random() * 100 ) );
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }
        }
    }
}
