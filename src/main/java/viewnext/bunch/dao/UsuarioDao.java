package viewnext.bunch.dao;

import viewnext.bunch.models.Usuario;

import java.util.List;

/**
 * @author Daniel Guirao
 */
public interface UsuarioDao {
	void agregarUsuario(Usuario usuario);

	Usuario recuperarUsuarioPorEmail(String email);

	List<Usuario> recuperarUsuarios();

	//void actualizarUsuario(Usuario usuario);

	void eliminarUsuario(String email);

}
