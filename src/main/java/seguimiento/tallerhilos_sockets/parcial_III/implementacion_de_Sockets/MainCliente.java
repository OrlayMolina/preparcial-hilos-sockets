package seguimiento.tallerhilos_sockets.parcial_III.implementacion_de_Sockets;

import java.io.IOException;

public class MainCliente {

    public static void main(String[] args) throws IOException {

        String[] numerosPropietarios = {
                "1094956466",
                "10444568996",
                "10945697631",
                "97856415"
        };

        String[] tipoVehiculos = {
                "automóvil",
                "motocicleta",
                "camioneta",
                "motocicleta"
        };

        Double[] cantidadGalones = {4.5, 4.8, 3.7, 4.2};

        String[] fechas = {
                "15/11/2023/08:00",
                "15/11/2023/08:32",
                "15/11/2023/08:34",
                "15/11/2023/09:35"
        };

        for(int i = 0; i<numerosPropietarios.length;i++){

            String info = numerosPropietarios[i]+";"+ tipoVehiculos[i]+";" +cantidadGalones[i]+";" +fechas[i];

            AppCliente appCliente = new AppCliente("localhost",8081, info);
            System.out.println("Iniciando cliente\n");
            appCliente.iniciarCliente();
        }
    }
}
