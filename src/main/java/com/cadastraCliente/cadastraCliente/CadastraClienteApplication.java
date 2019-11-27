package com.cadastraCliente.cadastraCliente;

import com.cadastraCliente.cadastraCliente.modelo.TipoUsuario;
import com.cadastraCliente.cadastraCliente.modelo.User;
import com.cadastraCliente.cadastraCliente.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class CadastraClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastraClienteApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository repository) {
		return args -> {
			repository.save(new User(1L,"admin",new BCryptPasswordEncoder(12).encode("123456"),null, TipoUsuario.ADMIN));
			repository.save(new User(2L,"user",new BCryptPasswordEncoder(12).encode("123456"),null, TipoUsuario.USER));
		};
	}

}
