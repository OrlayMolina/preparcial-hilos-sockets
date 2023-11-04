package seguimiento.tallerhilos_sockets.buscarPalabra;

import java.io.File;

public class HiloBusqueda1 extends Thread{

    private static String palabra;
    private String ruta;

    static int contador = 0;
    public HiloBusqueda1(String palabra, String ruta) {
        this.palabra = palabra;
        this.ruta = ruta;
    }

    @Override
    public void run() {

        File dir = new File(ruta);

        if (dir.exists() && dir.isDirectory()) {
            File[] archivos = dir.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    try {
                        if (archivo.isFile() && archivo.getName().contains(palabra)) {
                            contador++;
                            System.out.println("Archivos encontrados con la palabra '" + palabra + "' fueron " + contador);
                            sleep(2000);
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
