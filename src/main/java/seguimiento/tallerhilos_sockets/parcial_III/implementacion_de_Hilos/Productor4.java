package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Hilos;

import java.util.ArrayList;

public class Productor4 extends Thread{
    Main main = new Main();
    private Buffer buffer;
    private String arreglo;
    private final ArrayList<Character> caracterNoUsado;

    public Productor4(Buffer buffer, String arreglo, ArrayList<Character> caracterNoUsado) {
        this.buffer = buffer;
        this.arreglo = arreglo;
        this.caracterNoUsado = caracterNoUsado;
    }

    @Override
    public void run() {
        char c;

        while(true)
        {
            c = arreglo.charAt( (int)(Math.random()*44 ) );
            if(determinarCaracterEspecial(c)){
                buffer.lanzar( c );
                System.out.println( "Lanzado el carácter especial "+c+" al buffer" );
            }else {
                if(main.buscarElemento(caracterNoUsado, 0, caracterNoUsado.size()-1, c)){
                    caracterNoUsado.add(c);
                }
            }

            try
            {
                sleep( 350  );
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }
        }
    }

    public boolean determinarCaracterEspecial (char c) {
        if (c == '@' || c == '#' || c == '/' || c == '%' || c == '+' || c == ':' || c == ';') {
            return true;
        } else {
            return false;
        }
    }
}
