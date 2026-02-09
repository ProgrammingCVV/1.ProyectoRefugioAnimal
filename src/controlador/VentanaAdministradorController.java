/* REALIZADO POR:

*@author CHRYSTIAN VARGAS VALENZUELA 
*@author GABRIEL EDUARDO ZABALETA GARNICA 
*@author ANDRÉS DAVID MONTAÑA ARDILA 
*@author CLAUDIA MELISSA OCAMPO PARRA 
*@author NORBAIRON PULGARIN QUINTANA 
*/

package controlador;

import modelo.Usuario;
import modelo.UsuarioManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class VentanaAdministradorController 
{
	public static Stage stage2;

	
	 @FXML
	    private TextField userAdminText;   // Para el usuario
	    @FXML
	    private PasswordField passwordText;
	    private UsuarioManager UsuarioManager; // Instancia de UsuarioManager

	    public VentanaAdministradorController() 
	    {
	        UsuarioManager = new UsuarioManager(); // Inicializa el UsuarioManager
	    }
	    
	@FXML
	public void btnVolver(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Ventana1.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("APP - ANIMAL LINK");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
		//Cerrar la ventana actual
		Stage currentStage = (Stage) userAdminText.getScene().getWindow(); // Obtener la ventana actual
        currentStage.close(); // Cerrar la ventana actual
    }
		
	@FXML
	public void btnIniciar(ActionEvent event) throws IOException
	{
		 // Obtener el texto ingresado en el campo de usuario y contraseña
        String usuarioIngresado = userAdminText.getText();
        String contrasenaIngresada = passwordText.getText();
        
        // Verificar si el usuario y la contraseña son correctos
        Usuario usuarioValido = verificarUsuario(usuarioIngresado, contrasenaIngresada);
        
        if (usuarioValido != null) 
        {
            // Si el usuario es un administrador, cargamos la nueva ventana
            if (usuarioValido.getRol().equalsIgnoreCase("admin")) { // Ignorar mayúsculas
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaAdmin2.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("APP - ANIMAL LINK");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
                
             // Cerrar la ventana actual
                Stage currentStage = (Stage) userAdminText.getScene().getWindow(); // Obtener la ventana actual
                currentStage.close(); // Cerrar la ventana actual

                VentanaAdmin2Controller controlador2 = loader.getController();
                controlador2.setStage2(stage); 
            } else {
                // Mostrar un mensaje de error si el usuario no es un administrador
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de autenticación");
                alert.setHeaderText("Acceso denegado");
                alert.setContentText("Solo los administradores pueden acceder a esta sección.");
                alert.showAndWait();
            }
            
        } else {
            // Usuario o contraseña incorrectos, mostrar mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de autenticación");
            alert.setHeaderText("Usuario o contraseña incorrectos");
            alert.setContentText("Por favor, ingrese las credenciales correctas.");
            alert.showAndWait();
        }
        
	} 


        
  private Usuario verificarUsuario(String nombreUsuario, String contrasena) {
    // Verifica si el usuario existe en la lista y si la contraseña es correcta
    for (Usuario usuario : UsuarioManager.obtenerUsuarios()) 
    {
        if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario) && // Ignorar mayúsculas
            usuario.getContrasena().equals(contrasena)) {
            return usuario; 
        }
    }
    return null; 
}

 @FXML
 public void btnSalir(ActionEvent event) {
    System.exit(0); 
 }

}

/*
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaAdmin2.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setTitle("APP - ANIMAL LINK");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		
	//	ESTE CONTROLADOR ABAJO TRAE LA SIGUIENTE VENTANA QUE LLAMAMOS CON EL BOTÓN "INICIAR"
		VentanaAdmin2Controller controlador2 = loader.getController();
		Object primaryStage2 = null;  // SE DEBE DECLARAR AL OBJETO CREADO EN LA VENTANA CORRESPONDIENTE
		controlador2.setStage2(primaryStage2);
		((Stage) primaryStage2).show();
	//	
		VentanaAdministradorController.stage2.close();
		
	}
	
	@FXML
	public void btnSalir(ActionEvent event) 
	{
		System.exit(0);
	}
}
*/