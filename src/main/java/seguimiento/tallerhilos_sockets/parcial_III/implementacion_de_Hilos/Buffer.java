package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Hilos;

public class Buffer {

    private char buffer[] = new char[12];
    private int siguiente = 0;
    private boolean estaLlena = false;
    private boolean estaVacia = true;

    public synchronized char recoger()
    {
        while( estaVacia == true )
        {
            try {
                wait();
            } catch( InterruptedException e ) {
                ;
            }
        }
        siguiente--;
        if( siguiente == 0 )
            estaVacia = true;

        estaLlena = false;
        notify();

        return( buffer[siguiente] );
    }


    public synchronized void lanzar( char c )
    {
        while( estaLlena == true )
        {
            try {
                wait();
            } catch( InterruptedException e ) {
                ;
            }
        }

        buffer[siguiente] = c;
        siguiente++;
        if( siguiente == 12 )
            estaLlena = true;
        estaVacia = false;
        notify();
    }
}
