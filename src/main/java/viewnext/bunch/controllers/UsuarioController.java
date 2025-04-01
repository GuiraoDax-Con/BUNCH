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

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> usuarios() {
		return usuarioService.recuperarUsuarios();
	}

	@GetMapping(value = "/login/{usu}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@PathVariable Usuario usu) {
		return usuarioService.login(usu);
	}

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> register(@RequestBody Usuario usuario) {
		if (usuarioService.login(usuario)) {
			System.out.println("Login successful");
			return ResponseEntity.ok().body("Login successful");
		}

		return ResponseEntity.badRequest().body("Login failed");
	}


}