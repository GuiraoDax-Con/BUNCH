package viewnext.bunch.services;

import viewnext.bunch.models.Usuario;

import java.util.List;

/**
 * @author Daniel Guirao
 */
public interface UsuarioService {
	boolean login(Usuario usuario);
	//boolean login(String username, String password);

	boolean registrarUsuario(Usuario usuario);

	List<Usuario> recuperarUsuarios();

	//boolean actualizarUsuario(Usuario usuario);

	boolean eliminarUsuario(String email);


	Usuario buscarUsuario(String email);
}
