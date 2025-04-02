package viewnext.bunch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import viewnext.bunch.models.Usuario;
import viewnext.bunch.services.UsuarioServiceImpl;

import java.util.List;

/**
 * @author Daniel Guirao
 */
@CrossOrigin(origins = "*")  //Permite recibir peticiones desde cualquier origen
@RestController
@RequestMapping("/bunch/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@GetMapping(value = "/hellow", produces= MediaType.APPLICATION_JSON_VALUE)
	public String hello() {
		return "Hello World";
	}

	@GetMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> usuarios() {
		return usuarioService.recuperarUsuarios();
	}

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody Usuario usu) {
		System.out.println("Se a re cibido una solicitud de \"login\"");

		if (usuarioService.login(usu)) {
			System.out.println("Login successful");
			return true;
		} else {
			System.out.println("Login failed");
			return false;
		}
	}

/*
	@RequestMapping("/login2")
	public String login2(@RequestParam("email") String email, @RequestParam("password") String password) {
		System.out.println("Se a re cibido una solicitud de \"login2\"");

		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);

		if (usuarioService.login(usuario)) {
			System.out.println("Login successful");
			return "Login successful";
		} else {
			System.out.println("Login failed");
			return "Login failed";
		}
	}
*/


	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String register(@RequestBody Usuario usuario) {
		if (usuarioService.registrarUsuario(usuario)) {
			System.out.println("Usuario registrado con éxito");
			return "Usuario registrado con éxito";
		} else {
			System.out.println("El usuario ya existe");
			return "El usuario ya existe";
		}
	}


}