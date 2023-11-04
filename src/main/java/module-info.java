module seguimiento.tallerhilos_sockets {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens seguimiento.tallerhilos_sockets to javafx.fxml;
    exports seguimiento.tallerhilos_sockets;
    exports seguimiento.tallerhilos_sockets.buscarPalabra;
    opens seguimiento.tallerhilos_sockets.buscarPalabra to javafx.fxml;
}