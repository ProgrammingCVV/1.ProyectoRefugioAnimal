package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager implements Serializable {
    private List<Usuario> usuarios;
    private static final String FILE_PATH = "usuarios.dat";

    public UsuarioManager() {
        usuarios = new ArrayList<>();
        File file = new File(FILE_PATH);

        
        if (file.exists()) {
            cargarUsuarios();  
        } else {
           
            usuarios.add(new Usuario("admin", "admin123", "admin"));
            usuarios.add(new Usuario("cuidador1", "cuidador123", "cuidador"));
            guardarUsuarios();  
        }
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        guardarUsuarios();  
    }

    public void eliminarUsuario(String nombreUsuario) {
        usuarios.removeIf(usuario -> usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario));
        guardarUsuarios();  
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    private void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            usuarios = (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

