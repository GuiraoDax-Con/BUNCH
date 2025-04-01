package viewnext.bunch.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import viewnext.bunch.models.Usuario;

/**
 * @author Daniel Guirao
 */
public interface UsuarioJpaSpring  extends JpaRepository<Usuario, String> {
	Usuario findByEmail(String email);

	@Transactional
	@Modifying
	@Query("DELETE FROM Usuario u WHERE u.email = :email")
	void eliminarPorEmail(@Param("email") String email);

	boolean deleteByEmail(String email);

	boolean existsByEmail(String email);

	//Usuario updateUsuario(Usuario usuario);

}
