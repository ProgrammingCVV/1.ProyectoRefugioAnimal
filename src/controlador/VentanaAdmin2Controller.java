/* REALIZADO POR:

*@author CHRYSTIAN VARGAS VALENZUELA 
*@author GABRIEL EDUARDO ZABALETA GARNICA 
*@author ANDRÉS DAVID MONTAÑA ARDILA 
*@author CLAUDIA MELISSA OCAMPO PARRA 
*@author NORBAIRON PULGARIN QUINTANA 
*/
package controlador;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VentanaAdmin2Controller {

    private static Object stage3;
    
	@FXML
    private Text animal_link;
    @FXML
    private Button btnPrueba;
    @FXML
    private Button bntCerrarSesion;
    @FXML
    private TextField cmpNombre;
    @FXML
    private ImageView icono_huella;
    @FXML
    private ImageView prueba;
    @FXML
    private Text txtNombreCuidador;
    @FXML
    private AnchorPane ventanaAdmin2;
	@FXML
	private Button btnSalir2;
	@FXML
	private Text txtContrasenia;
	@FXML
	private TextField btnContrasenia;
    @FXML
    private TextField btnUsuario;
    @FXML
    private Text txtUsuario;
    @FXML
    void btnPrueba(ActionEvent event) 
    {
    }
    
    @FXML
    void txtContrasenia (ActionEvent event) 
    {
    }
    
    @FXML
    void btnContrasenia (ActionEvent event) 
    {
    }

    @FXML
    void btnUsuario (ActionEvent event) 
    {
    }
    
    @FXML
    void txtUsuario (ActionEvent event) 
    {
    }
    
    @FXML
    void cmpNombre(ActionEvent event) {

    }

    @FXML
    void prueba(MouseEvent event) {

    }

    @FXML
    void txtNombreCuidador(MouseEvent event) {

    }

    @FXML
    void ventanaAdmin2(MouseEvent event) {

    }
  /*  
  @FXML
    void btnGusuarios (ActionEvent evet) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaG_Usuarios.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setTitle("APP - ANIMAL LINK");
    	stage.setResizable(false);
    	stage.setScene(scene);
    	stage.show();
    	VentanaAdmin2Controller.stage3.close();
    	
    }
  */
	@FXML
	public void btnCerrarSesion(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Ventana1.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("APP - ANIMAL LINK");
		stage.setResizable(false);
		stage.setScene(scene);
	//	controller.init(stage, this);
		stage.show();
		
		Ventana1Controller controlador3 = loader.getController();
		Object primaryStage3 = null;  // SE DEBE DECLARAR AL OBJETO CREADO EN LA VENTANA CORRESPONDIENTE
		controlador3.setStage3(primaryStage3);
		((Stage) stage).show();
	//	
		((Stage)stage3).close();
		
	}


//
	public void setStage2(Object primaryStage2) 
	{		
	}
	
//
	
	
	@FXML
	public void btnSalir2(ActionEvent event) 
	{
		System.exit(0);
	}


}