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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VentanaInfoAnimalesController {

    @FXML
    private ImageView Encabezado;

    @FXML
    private Text animal_link;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField cmpIDanimal;

    @FXML
    private TextField cmpNombreAnimal;

    @FXML
    private ImageView icono_huella;

    @FXML
    private Text txtIDanimal;

    @FXML
    private Text txtNombreAnimal;
    
    @FXML
    private Button btnGaleria;
    
	
    @FXML
    void btnGaleria(ActionEvent event) throws IOException
    {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaGaleria.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("APP - ANIMAL LINK");
		stage.setResizable(false);
		stage.setScene(scene);
	//	controller.init(stage, this);
		stage.show();

    }


    @FXML
    void btnVolver(ActionEvent event) throws IOException
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

    }
    
	@FXML
	public void btnSalir(ActionEvent event) 
	{
		System.exit(0);
	}

}