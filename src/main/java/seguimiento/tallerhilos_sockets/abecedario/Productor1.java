package seguimiento.tallerhilos_sockets.abecedario;

import static seguimiento.tallerhilos_sockets.abecedario.MainAbecedario.letrasRecogidas;

public class Productor1 extends Thread{

    MainAbecedario main = new MainAbecedario();
    private Tuberia tuberia;
    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Productor1(Tuberia t )
    {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
    }

    public void run() {
        char c;

        // Mete 10 letras en la tubería
        for( int i=0; i < 13; i++ )
        {
            c = alfabeto.charAt( (int)(Math.random()*26 ) );
            if(main.buscarElemento(letrasRecogidas, 0, letrasRecogidas.size()-1, c)){
                letrasRecogidas.add(c);
                tuberia.lanzar( c );
                System.out.println( "Producto1 ha Lanzado "+c+" a la tuberia." );
            }
            try
            {
                sleep( 1500 );
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }
        }
    }
}
