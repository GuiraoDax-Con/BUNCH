package viewnext.bunch.models;

import jakarta.persistence.*;

/**
 * @author Daniel Guirao
 */
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(name = "email", unique = true, nullable = false)
	public String email;

	@Column(name = "password", nullable = false)
	public String password;

	// Constructores
	public Usuario() {

	}
	public Usuario(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public Usuario(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	// GETTER & SETTER
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	// toString

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
