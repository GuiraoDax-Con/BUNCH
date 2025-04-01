package viewnext.bunch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import viewnext.bunch.models.Usuario;

import java.util.List;

/**
 * @author Daniel Guirao
 */
@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	UsuarioJpaSpring user;


	@Override
	public void agregarUsuario(Usuario usuario) {
		user.save(usuario);
	}

	@Override
	public Usuario recuperarUsuarioPorEmail(String email) {
		return user.findByEmail(email);
	}

	@Override
	public List<Usuario> recuperarUsuarios() {
		return user.findAll();
	}

/*
	@Override
	public void actualizarUsuario(Usuario usuario) {
		user.updateUsuario(usuario);
	}
*/

	@Override
	public void eliminarUsuario(String email) {
		user.deleteByEmail(email);
	}

	public void eliminarPorEmail(String email) {
		user.eliminarPorEmail(email);
	}
}
