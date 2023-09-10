package utn.estudiantes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.Logger.Factory;
import org.springframework.beans.factory.annotatio.Autowired;
import utn.estudiantes.servicio.EstudianteServicio;




@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {
	@Autowired
	private EstudianteServicio estudianteServicio;
	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);


	String nl = System.lineSeparator();


	public static void main(String[] args) {
		logger.info("iniciando la aplicacion ...");
		//Levantar la fabrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aolicacion Finalizada!");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Ejecutando el metodo Run de Spring...");
		logger.info("Ejecutando el metodo Run de Spring...");
	}
}
