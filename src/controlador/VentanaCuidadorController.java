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
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class VentanaCuidadorController {

    @FXML
    private TextField userAdminText;   // Para el usuario
    @FXML
    private PasswordField passwordText; // Para la contraseña
    private static Stage stage4;

    private UsuarioManager usuarioManager; // Instancia de UsuarioManager

    public VentanaCuidadorController() {
        usuarioManager = new UsuarioManager(); // Inicializa el UsuarioManager
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
        VentanaCuidadorController.stage4.close();
    }

    @FXML
    public void btnIniciar1(ActionEvent event) throws IOException {
        // Obtener el texto ingresado en el campo de usuario y contraseña
        String usuarioIngresado = userAdminText.getText();
        String contrasenaIngresada = passwordText.getText();
        
        // Verificar si el usuario y la contraseña son correctos
        Usuario usuarioValido = verificarUsuario(usuarioIngresado, contrasenaIngresada);
        
        if (usuarioValido != null) {
            // Verificar el rol del usuario
            if ("cuidador".equalsIgnoreCase(usuarioValido.getRol())) {
                // Si el usuario es cuidador, cargamos la nueva ventana
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaCuidador2.fxml"));
                Parent root = loader.load();
                VentanaCuidador2Controller controller = loader.getController();
                controller.setUsuario(usuarioValido); 
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("APP - ANIMAL LINK");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();

                // Cerrar la ventana actual
                Stage currentStage = (Stage) userAdminText.getScene().getWindow(); // Obtener la ventana actual
                currentStage.close(); // Cerrar la ventana actual
            } else {
                // Si no es cuidador, mostrar mensaje de acceso denegado
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Acceso denegado");
                alert.setHeaderText("Acceso restringido");
                alert.setContentText("Solo los cuidadores pueden acceder a esta sección.");
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
        for (Usuario usuario : usuarioManager.obtenerUsuarios()) {
            // Compara el nombre de usuario sin importar mayúsculas/minúsculas
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario) &&
                usuario.getContrasena().equals(contrasena)) { // Aquí se mantiene 'equals' para la contraseña
                return usuario; // Retorna el usuario si es válido
            }
        }
        return null; // Retorna null si no se encuentra un usuario válido
    }

    private void setStage4(Stage primaryStage4) {
        VentanaCuidadorController.stage4 = primaryStage4;
    }

    @FXML
    public void btnSalir(ActionEvent event) {
        System.exit(0);
    }
}

