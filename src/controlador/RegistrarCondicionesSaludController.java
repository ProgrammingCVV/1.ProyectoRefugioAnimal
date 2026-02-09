package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.time.LocalDate;

public class RegistrarCondicionesSaludController {
	 public static Stage stage7;
    @FXML
    private ComboBox<String> comboAnimal; 
    @FXML
    private TextArea textObservaciones;    
    @FXML
    private TextField textPeso;            
    @FXML
    private TextField textVacunas;         
    @FXML
    private DatePicker dateRegistro;       
    @FXML
    public void initialize() {
        
        comboAnimal.getItems().addAll("Perro", "Gato", "Conejo", "Loro");

        
        dateRegistro.setValue(LocalDate.now());
    }

    @FXML
    private void registrarCondicionesSalud() {
        String animalSeleccionado = comboAnimal.getValue();
        String observaciones = textObservaciones.getText();
        String peso = textPeso.getText();
        String vacunas = textVacunas.getText();
        LocalDate fechaRegistro = dateRegistro.getValue();

        if (animalSeleccionado == null || observaciones.isEmpty() || peso.isEmpty() || vacunas.isEmpty()) {
         
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setTitle("Campos Vacíos");
            alerta.setHeaderText("Debe completar todos los campos.");
            alerta.showAndWait();
        } else {
           
            System.out.println("Registro de Salud:");
            System.out.println("Animal: " + animalSeleccionado);
            System.out.println("Observaciones: " + observaciones);
            System.out.println("Peso: " + peso);
            System.out.println("Vacunas: " + vacunas);
            System.out.println("Fecha de Registro: " + fechaRegistro);

       
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Registro Exitoso");
            alerta.setHeaderText("Las condiciones de salud se han registrado correctamente.");
            alerta.showAndWait();
        }
    }
}
