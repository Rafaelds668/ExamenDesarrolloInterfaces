package com.example.examendesarrollointerfaces;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @javafx.fxml.FXML
    private TextField txtMatricula;
    @javafx.fxml.FXML
    private ComboBox comboModelo;
    @javafx.fxml.FXML
    private ComboBox comboCliente;
    @javafx.fxml.FXML
    private RadioButton rbtnStandard;
    @javafx.fxml.FXML
    private RadioButton rbtnOferta;
    @javafx.fxml.FXML
    private RadioButton rbtnLargaDuracion;
    @javafx.fxml.FXML
    private DatePicker dateEntrada;
    @javafx.fxml.FXML
    private DatePicker dateSalida;
    @javafx.fxml.FXML
    private Label labelCoste;
    @javafx.fxml.FXML
    private Button btnAdd;
    @javafx.fxml.FXML
    private Button btnSalir;
    @javafx.fxml.FXML
    private TableColumn cMatricula;
    @javafx.fxml.FXML
    private TableColumn cModelo;
    @javafx.fxml.FXML
    private TableColumn cEntrada;
    @javafx.fxml.FXML
    private TableColumn cSalida;
    @javafx.fxml.FXML
    private TableColumn cCliente;
    @javafx.fxml.FXML
    private TableColumn cTarifa;
    @javafx.fxml.FXML
    private TableColumn cCoste;

    @javafx.fxml.FXML
    public void salir(ActionEvent actionEvent) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
