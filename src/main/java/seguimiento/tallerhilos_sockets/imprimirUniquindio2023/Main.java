package seguimiento.tallerhilos_sockets.imprimirUniquindio2023;

public class Main {

    public static void main(String[] args) {//


        Tuberia tuberia = new Tuberia();
        ProductorUno productorUno = new ProductorUno(tuberia);
        ProductorDos productorDos = new ProductorDos(tuberia);
        ProductorTres productorTres = new ProductorTres(tuberia);
        Consumidor consumidor = new Consumidor(tuberia);
        productorUno.start();
        productorDos.start();
        productorTres.start();
        consumidor.start();

    }
}
