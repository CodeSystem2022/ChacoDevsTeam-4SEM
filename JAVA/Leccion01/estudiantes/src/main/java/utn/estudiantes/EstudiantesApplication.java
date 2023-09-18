package utn.estudiantes;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import utn.estudiantes.modelo.Estudiante2022;
import utn.estudiantes.servicio.EstudianteServicio;

import java.util.Scanner;

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
		logger.info("Aplicacion Finalizada!");
	}
	@Override
	public void run(String... args) throws Exception {
		logger.info(nl+"Ejecutando el metodo Run de Spring..."+nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			mostrarMenu();
			salir= ejecutarOpciones(consola);
			logger.info(nl);
		}// Fin ciclo while
	}

	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
				******* Sistema de Estudiantes *******
				1. Listar Estudiantes
				2. Buscar Estudiante
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. Salir
				Elija una opcion:""");
	}

	private boolean ejecutarOpciones(Scanner consola){
	var opcion = Integer.parseInt(consola.nextLine());
	var salir = false;
	switch (opcion) {
		case 1 -> {//Listar estudiantes
			logger.info(nl + "Listado de estudiantes: " + nl);
			List<Estudiantes2022> estudiantes = estudianteServicio.listarEstudiantes();
			estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));
		}
		case 2 -> { // Buscar estudiante en id
			logger.info("Digite el idd estudiante a buscar: ");
			var idEstudiante = Integer.parseInt(consola.nextLine());
			Estudiante2022 estudiante =
					estudianteServicio.buscarEstudaintePorId((idEstudiante));
			if (estudiante != null)
				logger.info("Estudiante encontrado: " + estudiante + nl);
			else
				logger.info("Estudiante NO encontrado: " + estudiante + nl);
		}
		case 3 -> { // Agregar Estudiante
			logger.info("Agregar estudiante: " + nl);
			logger.info("Nombre: ");
			var nombre = consola.nextLine();
			logger.info("Apellido: ");
			var apellido = consola.nextLine();
			logger.info("Telefono: ");
			var telefono = consola.nextLine();
			logger.info("Email: ");
			var email = consola.nextLine();
			//crear el objeto estudiante sin el id
			var estudiante = new Estudiante2022();
			estudiante.setNombre(nombre);
			estudiante.setApellido(apellido);
			estudiante.setTelefono(telefono);
			estudiante.setEmail(email);
			estudianteServicio.guardarEstudiante((estudiante));
			logger.info("Estudiante agregado: " + estudiante + nl);
		}
		case 4 -> { // Modificar Estudiante
			logger.info("Modificar estudiante: " + nl);
			logger.info("Ingrese el id estudiante: ");
			var idEstudiante = Integer.parseInt(consola.nextLine());
			//Buscamos estudiante a modificar
			Estudiante2022 estudiante =
					estudianteServicio.buscarEstudaintePorId(idEstudiante);
			if (estudiante != null){
				logger.info("Nombre: ");
			var nombre = consola.nextLine();
			logger.info("Apellido: ");
			var apellido = consola.nextLine();
			logger.info("Telefono: ");
			var telefono = consola.nextLine();
			logger.info("Email: ");
			var email = consola.nextLine();
			estudiante.setNombre(nombre);
			estudiante.setApellido(apellido);
			estudiante.setTelefono(telefono);
			estudiante.setEmail(email);
			estudianteServicio.guardarEstudiante(estudiante);
			logger.info("Estudiante Modificado: " + estudiante + nl);
		}
		else
		logger.info("Estudiante NO encontrado con el id: " + idEstudiante + nl);
		}
	}//fin Switch
	return salir;
}
}
