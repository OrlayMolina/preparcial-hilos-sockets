module seguimiento.tallerhilos_sockets {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;


    opens seguimiento.tallerhilos_sockets to javafx.fxml;
    exports seguimiento.tallerhilos_sockets;
    exports seguimiento.tallerhilos_sockets.buscarPalabra;
    opens seguimiento.tallerhilos_sockets.buscarPalabra to javafx.fxml;
    exports seguimiento.tallerhilos_sockets.interfazGrafica.viewController;
    opens seguimiento.tallerhilos_sockets.interfazGrafica.viewController to javafx.fxml;
    exports seguimiento.tallerhilos_sockets.interfazGrafica.model;
    opens seguimiento.tallerhilos_sockets.interfazGrafica.model to javafx.fxml;
    exports seguimiento.tallerhilos_sockets.interfazGrafica.util;
    opens seguimiento.tallerhilos_sockets.interfazGrafica.util to javafx.fxml;
    exports seguimiento.tallerhilos_sockets.interfazGrafica.mapping.dto;
    opens seguimiento.tallerhilos_sockets.interfazGrafica.mapping.dto to javafx.fxml;
    exports seguimiento.tallerhilos_sockets.interfazGrafica.mapping.mappers;
    opens seguimiento.tallerhilos_sockets.interfazGrafica.mapping.mappers to javafx.fxml;

}