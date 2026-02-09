/* REALIZADO POR:

*@author CHRYSTIAN VARGAS VALENZUELA 
*@author GABRIEL EDUARDO ZABALETA GARNICA 
*@author ANDRÉS DAVID MONTAÑA ARDILA 
*@author CLAUDIA MELISSA OCAMPO PARRA 
*@author NORBAIRON PULGARIN QUINTANA 
*/

package application;
	
import java.io.IOException;
import controlador.Ventana1Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Ventana1.fxml"));	 // Cargará la vista con todos los atributos de la Ventana1Controller, interfaz de inicio.
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("APP - ANIMAL LINK");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);	 //Evita la modificación de las dimensiones de la ventana.
			
			
			Ventana1Controller controlador = loader.getController(); //Cargará y mostrará la Ventana1Controller
			controlador.setStage(primaryStage);
			primaryStage.show();
		} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
	}
	
		public static void main(String[] args) 
		{
			launch(args);
		}
}
