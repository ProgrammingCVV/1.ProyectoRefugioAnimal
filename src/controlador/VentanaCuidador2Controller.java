/* REALIZADO POR:

*@author CHRYSTIAN VARGAS VALENZUELA 
*@author GABRIEL EDUARDO ZABALETA GARNICA 
*@author ANDRÉS DAVID MONTAÑA ARDILA 
*@author CLAUDIA MELISSA OCAMPO PARRA 
*@author NORBAIRON PULGARIN QUINTANA 
*/

package controlador;

import modelo.Usuario;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VentanaCuidador2Controller {
    public static Stage stage5;

    @FXML
    private Text nombreUsuario;  
    @FXML
    private ImageView avatar;     
    @FXML
    private Button btnVolver;    
    @FXML
    private Button btnSalir;      
    @FXML
    private Button btnAsignarAnimales; 
    @FXML
    private Button btnListarAnimales; 
    @FXML
    private Button btnRegistrarCondicionesSalud; 
    @FXML
    private Button btnControlesMedicos; 
    @FXML
    private Button btnRegistrarAccidentesEnfermedades; 

    private Usuario usuarioActual; 

    public void initialize() {
        // Inicialización (si la necesitas)
    }

    public void setUsuario(Usuario usuario) {
        this.usuarioActual = usuario; 
        nombreUsuario.setText(usuario.getNombreUsuario()); 
    }

    @FXML
    public void btnVolver(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Ventana1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("APP - ANIMAL LINK");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) btnVolver.getScene().getWindow();
        currentStage.close(); 
    }

    @FXML
    public void btnSalir() {
        System.exit(0); 
    }

    @FXML
    public void btnAsignarAnimales() {
    }

    @FXML
    public void btnListarAnimales() {
       
    }

    @FXML
    public void btnRegistrarCondicionesSalud() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaRegistrarCondicionesSalud.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setTitle("APP - ANIMAL LINK");
    	stage.setResizable(false);
    	stage.setScene(scene);
    	stage.show();
    	VentanaCuidador2Controller.stage5.close();
    }

    @FXML
    public void btnControlesMedicos() {
        
    }

    @FXML
    public void btnRegistrarAccidentesEnfermedades() {
      
    }
}

