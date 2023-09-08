package utn.estudiantes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EstudiantesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
