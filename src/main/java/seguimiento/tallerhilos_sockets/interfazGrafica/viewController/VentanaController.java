package seguimiento.tallerhilos_sockets.interfazGrafica.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VentanaController {

    @FXML
    private TableColumn<?, String> colApellidos;

    @FXML
    private TableColumn<?, String> colDocumento;

    @FXML
    private TableColumn<?, String> colEdad;

    @FXML
    private TableColumn<?, String> colNombres;

    @FXML
    private TableColumn<?, String> colOcupacion;

    @FXML
    private TableView<?> tableEstudiante;

    @FXML
    private TextField txfApellidos;

    @FXML
    private TextField txfDocumento;

    @FXML
    private TextField txfEdad;

    @FXML
    private TextField txfNombres;

    @FXML
    private TextField txfOcupacion;

    @FXML
    void buscarEstudiante(ActionEvent event) {

    }

    @FXML
    void cancelarBusqueda(ActionEvent event) {

    }

}
