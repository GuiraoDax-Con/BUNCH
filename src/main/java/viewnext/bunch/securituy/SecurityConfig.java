package viewnext.bunch.securituy;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author Daniel Guirao
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Deshabilitar CSRF para permitir peticiones desde Postman y otras fuentes
            .authorizeHttpRequests()
                .requestMatchers("/bunch/usuarios/**").permitAll() // Permitir todas las peticiones a los endpoints del controlador Usuario
            .anyRequest().authenticated(); // Requerir autenticación para cualquier otra petición

        return http.build();
    }
}
