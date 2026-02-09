/* REALIZADO POR:

*@author CHRYSTIAN VARGAS VALENZUELA 
*@author GABRIEL EDUARDO ZABALETA GARNICA 
*@author ANDRÉS DAVID MONTAÑA ARDILA 
*@author CLAUDIA MELISSA OCAMPO PARRA 
*@author NORBAIRON PULGARIN QUINTANA 
*/

package controlador;

import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Ventana1Controller 
{
	public void setStage3(Object primaryStage3) //Declara el contenido de la VentanaAdmin2Controller
	{
	}
	private static Stage stage;

	
	@FXML
	private Button btnCuidador;
	

	@FXML
	private void btnCuidador(ActionEvent event) throws IOException
	{
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaCuidador.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("APP - ANIMAL LINK");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		Ventana1Controller.stage.close();	
	}	
	
	@FXML
	private Button btnAdministrador;
	@FXML
	public void btnAdministrador(ActionEvent event) throws IOException 
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaAdministrador.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("APP - ANIMAL LINK");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		Ventana1Controller.stage.close();
	}
	
	@FXML
	private Button btnInfoAnimales;

	@FXML
	private void btnInfoAnimales(ActionEvent event) throws IOException 
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaInfoAnimales.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("APP - ANIMAL LINK");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		Ventana1Controller.stage.close();
	}
	
	public void setStage(Stage primaryStage) 
	{
		stage = primaryStage;									//Guarda la ventana enviada en Main.
	}

	@FXML
	public static void show() 
	{
		stage.show();
	}
	
	@FXML
	public void btnSalir(ActionEvent event) 
	{
		System.exit(0);
	}


}


