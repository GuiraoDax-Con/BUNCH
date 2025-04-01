package viewnext.bunch.repository;

import viewnext.bunch.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Daniel Guirao
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
