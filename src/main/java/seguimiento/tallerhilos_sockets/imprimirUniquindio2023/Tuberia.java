package seguimiento.tallerhilos_sockets.imprimirUniquindio2023;

public class Tuberia {

    char[] buffer =new char[12];
    int posicion=0;
    boolean estaLlena=false;
    boolean estaVacio=true;
    public synchronized void cogerProductorUno(char letra){
        //System.out.println(Thread.currentThread().getName());
        while (estaLlena){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(posicion>=11){
            estaLlena=true;
        }
        buffer[posicion] = letra;
        posicion++;
        estaVacio=false;
        notify();
    }
    public synchronized void cogerProductorDos(char letra){
        //System.out.println(Thread.currentThread().getName());
        while (estaLlena){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(posicion>=11){
            estaLlena=true;
        }
        buffer[posicion] = letra;
        posicion++;
        estaVacio=false;
        notify();
    }
    public synchronized void cogerProductorTres(char letra){

        //System.out.println(Thread.currentThread().getName());
        while (estaLlena){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(posicion>=11){
            estaLlena=true;
        }
        buffer[posicion] = letra;
        posicion++;
        estaVacio=false;
        notify();
    }
    public synchronized char lanzarConsumidorUno(){
        //System.out.println(Thread.currentThread().getName());
        while (estaVacio){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        posicion--;
        if(posicion==0){
            estaVacio=true;
        }
        estaLlena=false;
        notify();
        return (buffer[posicion]);
    }


    public synchronized char lanzarConsumidoDos(){
        //System.out.println(Thread.currentThread().getName());
        while (estaVacio){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        posicion--;
        if(posicion==0){
            estaVacio=true;
        }
        estaLlena=false;
        notify();
        return (buffer[posicion]);
    }
}
