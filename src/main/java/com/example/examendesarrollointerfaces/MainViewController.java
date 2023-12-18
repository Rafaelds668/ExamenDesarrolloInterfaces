package com.example.examendesarrollointerfaces;

import com.example.examendesarrollointerfaces.Cliente.Cliente;
import com.example.examendesarrollointerfaces.Coche.Coche;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainViewController implements Initializable {
    @javafx.fxml.FXML
    private TextField txtMatricula;
    @javafx.fxml.FXML
    private ComboBox <String> comboModelo;
    @javafx.fxml.FXML
    private ComboBox <String> comboCliente;
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
    private TableColumn <Coche, String> cMatricula;
    @javafx.fxml.FXML
    private TableColumn <Coche, String> cModelo;
    @javafx.fxml.FXML
    private TableColumn <Coche, String> cEntrada;
    @javafx.fxml.FXML
    private TableColumn <Coche, String> cSalida;
    @javafx.fxml.FXML
    private TableColumn <Coche, String> cCliente;
    @javafx.fxml.FXML
    private TableColumn <Coche, String> cTarifa;
    @javafx.fxml.FXML
    private TableColumn <Coche, String> cCoste;
    @javafx.fxml.FXML
    private TableView <Coche> tvParking;
    @javafx.fxml.FXML
    private Label labelInfo;
    @FXML
    private ToggleGroup tarifa;

    @javafx.fxml.FXML
    public void salir(ActionEvent actionEvent) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> modelos = FXCollections.observableArrayList();
        modelos.add("Peugeot");
        modelos.add("Seat");
        modelos.add("Mercedes");
        comboModelo.setItems( modelos );
        comboModelo.getSelectionModel().selectFirst();

        ObservableList<String> clientes = FXCollections.observableArrayList();
        clientes.add("Jorge");
        clientes.add("Raul");
        clientes.add("Rafael");
        comboCliente.setItems( clientes );
        comboCliente.getSelectionModel().selectFirst();

        cMatricula.setCellValueFactory( (fila) -> {
            String matricula = fila.getValue().getMatricula();
            return new SimpleStringProperty( matricula);
        });

        cModelo.setCellValueFactory( (fila) -> {
            String modelo = fila.getValue().getModelo();
            return new SimpleStringProperty( modelo);
        });

        cEntrada.setCellValueFactory( (fila) -> {
            LocalDate entrada = fila.getValue().getEntrada();
            return new SimpleStringProperty( entrada.toString());
        });

        cSalida.setCellValueFactory( (fila) -> {
            LocalDate salida = fila.getValue().getSalida();
            return new SimpleStringProperty( salida.toString());
        });

        cCliente.setCellValueFactory( (fila) -> {
            String cliente = fila.getValue().getCliente().getNombre();
            return new SimpleStringProperty( cliente);
        });

        cTarifa.setCellValueFactory( (fila) -> {
            String tarifa = fila.getValue().getTarifa();
            return new SimpleStringProperty( tarifa);
        });

        cCoste.setCellValueFactory( (fila) -> {
            Double coste = fila.getValue().getCosteTotal();
            return new SimpleStringProperty( coste.toString());
        });

        labelInfo.setOnMouseClicked(event-> MostraAlert());

    }

    private void MostraAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creador de la Aplicacion");
        alert.setHeaderText(null);
        alert.setContentText("Rafael Delgado Shepherd 2ºDAM");
        alert.showAndWait();
    }


    @javafx.fxml.FXML
    public void añadir(ActionEvent actionEvent) {
        Alert alert = new Alert( Alert.AlertType.WARNING );
        if(txtMatricula.getText().isEmpty()){
            alert.setContentText( "El campo matricula no puede estar vacio" );
            alert.show();
        }
        else if(tarifa.getSelectedToggle()==null){
            alert.setContentText( "debe seleccionar una tarifa" );
            alert.show();
        }
        else if(dateEntrada.getValue()==null){
            alert.setContentText( "debe seleccionar una fecha de entrada" );
            alert.show();
        }
        else if(dateSalida.getValue()==null){
            alert.setContentText( "debe seleccionar una fecha de salida" );
            alert.show();
        }
        else{


            Cliente cliente = new Cliente();
            Coche coche = new Coche(txtMatricula.getText(), comboModelo.getValue(), cliente, tarifa.selectedToggleProperty().getName() , dateEntrada.getValue() , dateSalida.getValue());
            cliente.setNombre( comboCliente.getValue() );
            ObservableList<Coche> observableCoches= FXCollections.observableArrayList();
            observableCoches.add( coche );
            tvParking.setItems( observableCoches );
            txtMatricula.setText( "" );
            dateEntrada.setValue( null );
            dateSalida.setValue( null );

    }



    }
}
