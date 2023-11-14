package seguimiento.tallerhilos_sockets.imprimirUniquindio2023;

public class ProductorDos extends Thread{

    boolean arrancar=true;
    String consonantes="bcdfghjklmnpqrstwxyz";
    Tuberia tuberia;
    public ProductorDos(Tuberia tuberia){
        this.tuberia=tuberia;
    }

    @Override
    public void run() {
        while (arrancar){
            char letra=consonantes.charAt((int)(Math.random()*consonantes.length() ));
            tuberia.cogerProductorDos(letra);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
