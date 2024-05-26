package co.uniquindio.parqueadero.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ParqueaderoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCarro;

    @FXML
    private Button btnMotoClasica;

    @FXML
    private Button btnMotoHibrida;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField txMarcaVehiculo;

    @FXML
    private TextField txNombre;

    @FXML
    private TextField txPlaca;

    @FXML
    void RegistrarUsuario(ActionEvent event) {
        System.out.println("Te has registrado en el parqueadero!");
    }

    @FXML
    void tenerCarro(ActionEvent event) {
        System.out.println("Vehiculo registrado: CARRO");
    }

    @FXML
    void tenerMotoC(ActionEvent event) {
        System.out.println("Vehiculo registrado: MOTO CLASICA");
    }

    @FXML
    void tenerMotoH(ActionEvent event) {
        System.out.println("Vehiculo registrado: MOTOHIBRIDA");

    }

    @FXML
    void initialize() {
    }

}
