package viewnext.bunch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import viewnext.bunch.dao.UsuarioDao;
import viewnext.bunch.dao.UsuarioDaoImpl;
import viewnext.bunch.models.Usuario;
import viewnext.bunch.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDaoImpl dao;


    @Override
    public boolean login(Usuario usuario) {
        if (dao.recuperarUsuarioPorEmail(usuario.getEmail()) == null) {
            System.err.println("El usuario no existe");
            return false;
        }

        if (dao.recuperarUsuarioPorEmail(
                usuario.getEmail())
                    .getPassword()
                    .equals(usuario.
                        getPassword())) {

            System.out.println("El usuario a iniciado sesión");
            return true;
        }

        return false;
    }

    @Override
    public boolean registrarUsuario(Usuario usuario) {
        if (dao.recuperarUsuarioPorEmail(usuario.getEmail()) == null) {
            dao.agregarUsuario(usuario);
            return true;
        }

        return false;
    }

    @Override
    public List<Usuario> recuperarUsuarios() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            /*throw new RuntimeException(e);*/
            e.printStackTrace();
        }

        return dao.recuperarUsuarios();
    }

/*
    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        if (dao.recuperarUsuarioPorEmail(usuario.getEmail()) == null) {


            dao.actualizarUsuario(usuario);
            return true;
        }

        return false;
    }
*/

    @Override
    public boolean eliminarUsuario(String email) {
        if (dao.recuperarUsuarioPorEmail(email) != null) {
            dao.eliminarUsuario(email);
            return true;
        }

        return false;
    }

    @Override
    public Usuario buscarUsuario(String email) {
        return dao.recuperarUsuarioPorEmail(email);
    }
}
