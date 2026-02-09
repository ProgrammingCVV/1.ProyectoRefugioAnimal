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
import javafx.stage.Stage;

public class VentanaGaleriaController 
{
	

    @FXML
    private Button btnSalir2;

    @FXML
    private Button btnVolver;


    @FXML
    void btnVolver(ActionEvent event) throws IOException
    {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaInfoAnimales.fxml"));
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
	public void btnSalir2(ActionEvent event) 
	{
		System.exit(0);
	}


}
