package seguimiento.tallerhilos_sockets.abecedario;

import static seguimiento.tallerhilos_sockets.abecedario.MainAbecedario.letrasRecogidas;

public class Productor2 extends Thread{

    MainAbecedario main = new MainAbecedario();
    private Tuberia tuberia;
    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Productor2(Tuberia t )
    {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
    }

    public void run() {
        char c;

        // Mete 10 letras en la tubería
        for (int i = 0; i < 13; i++) {
            c = alfabeto.charAt((int) (Math.random() * 26));

            boolean elementoAgregado = false; // Variable para verificar si se agregó el elemento

            while (!elementoAgregado) {
                if (main.buscarElemento(letrasRecogidas, 0, letrasRecogidas.size() - 1, c)) {
                    letrasRecogidas.add(c);
                    tuberia.lanzar(c);
                    System.out.println("Producto2 ha Lanzado " + c + " a la tuberia.");
                    elementoAgregado = true; // Se establece como verdadero una vez que se agregó el elemento
                } else {
                    c = alfabeto.charAt((int) (Math.random() * 26)); // Generar un nuevo carácter si el anterior ya estaba en la lista
                }
            }

            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
}
