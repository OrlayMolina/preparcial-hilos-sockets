package seguimiento.tallerhilos_sockets.imprimirUniquindio2023;

public class ProductorUno extends Thread{

    String vocales="aeiuo";
    Tuberia tuberia;
    public ProductorUno(Tuberia tuberia){
        this.tuberia=tuberia;
    }
    boolean arrancar=true;
    @Override
    public void run() {
        char letra;
        while (arrancar){
            letra=vocales.charAt((int)(Math.random()*vocales.length() ));
            tuberia.cogerProductorUno(letra);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
