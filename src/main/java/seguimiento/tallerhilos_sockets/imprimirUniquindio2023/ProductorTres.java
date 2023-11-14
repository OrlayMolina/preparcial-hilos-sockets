package seguimiento.tallerhilos_sockets.imprimirUniquindio2023;

public class ProductorTres extends Thread{

    boolean arrancar=true;
    String numeros="0123456789";
    Tuberia tuberia;
    public ProductorTres (Tuberia tuberia){
        this.tuberia=tuberia;
    }

    @Override
    public void run() {
        while (arrancar){
            char letra=numeros.charAt((int)(Math.random()*numeros.length()));
            tuberia.cogerProductorTres(letra);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
