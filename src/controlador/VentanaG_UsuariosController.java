/* REALIZADO POR:

*@author CHRYSTIAN VARGAS VALENZUELA 
*@author GABRIEL EDUARDO ZABALETA GARNICA 
*@author ANDRÉS DAVID MONTAÑA ARDILA 
*@author CLAUDIA MELISSA OCAMPO PARRA 
*@author NORBAIRON PULGARIN QUINTANA 
*/

package controlador;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Usuario;
import modelo.UsuarioManager;

public class VentanaG_UsuariosController {
    public static Stage stage6;

    @FXML
    private TableView<Usuario> tablaUsuarios;

    @FXML
    private TableColumn<Usuario, String> colNombre;

    @FXML
    private TableColumn<Usuario, String> colRol;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtRol;

    private UsuarioManager usuarioManager;
    private ObservableList<Usuario> listaUsuarios;

    public VentanaG_UsuariosController() {
        usuarioManager = new UsuarioManager(); 
    }

    @FXML
    public void initialize() {
        
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));

        
        listaUsuarios = FXCollections.observableArrayList(usuarioManager.obtenerUsuarios());
        tablaUsuarios.setItems(listaUsuarios);
    }

    @FXML
    public void btnAgregarUsuario() {
        String nombre = txtNombreUsuario.getText();
        String contrasena = txtContrasena.getText();
        String rol = txtRol.getText();

        if (!nombre.isEmpty() && !contrasena.isEmpty() && (rol.equals("admin") || rol.equals("cuidador"))) {
            Usuario nuevoUsuario = new Usuario(nombre, contrasena, rol);
            usuarioManager.agregarUsuario(nuevoUsuario);
            listaUsuarios.add(nuevoUsuario);
            limpiarCampos();
        } else {
            mostrarAlerta("Error", "Datos inválidos", "Por favor, complete todos los campos correctamente.");
        }
    }

    @FXML
    public void btnEliminarUsuario() {
        Usuario usuarioSeleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado != null) {
            usuarioManager.eliminarUsuario(usuarioSeleccionado.getNombreUsuario());
            listaUsuarios.remove(usuarioSeleccionado);
        } else {
            mostrarAlerta("Error", "Selección vacía", "Seleccione un usuario para eliminar.");
        }
    }

    @FXML
    public void btnEditarUsuario() {
        Usuario usuarioSeleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado != null) {
            String nuevoNombre = txtNombreUsuario.getText();
            String nuevaContrasena = txtContrasena.getText();
            String nuevoRol = txtRol.getText();

            if (!nuevoNombre.isEmpty() && !nuevaContrasena.isEmpty() && (nuevoRol.equals("admin") || nuevoRol.equals("cuidador"))) {
                usuarioSeleccionado.setNombreUsuario(nuevoNombre);
                usuarioSeleccionado.setContrasena(nuevaContrasena);
                usuarioSeleccionado.setRol(nuevoRol);
                tablaUsuarios.refresh();  // Refrescar la tabla para mostrar los cambios
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "Datos inválidos", "Complete correctamente los campos.");
            }
        } else {
            mostrarAlerta("Error", "Selección vacía", "Seleccione un usuario para editar.");
        }
    }

    private void limpiarCampos() {
        txtNombreUsuario.clear();
        txtContrasena.clear();
        txtRol.clear();
    }

    private void mostrarAlerta(String titulo, String cabecera, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecera);
        alerta.setContentText(contenido);
        alerta.showAndWait();
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

        // Cerrar la ventana actual
        Stage currentStage = (Stage) txtNombreUsuario.getScene().getWindow(); // Obtener la ventana actual
        currentStage.close(); // Cerrar la ventana actual
    }

    @FXML
    public void btnSalir(ActionEvent event) {
        System.exit(0);
    }
}
