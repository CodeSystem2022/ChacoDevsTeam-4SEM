 package UTN.presentacion;

import UTN.conexion.Conexion;
import UTN.datos.EstudianteDAO;
import UTN.dominio.Estudiante;

import java.util.Scanner;

 public class SistemaEstudiantesApp {
     public static void main(String[] args) {
         var salir = false;
         var consola = new Scanner(System.in); // Para leer informacion de la consola
         // se crea una instancia de la clase servicio , esto lo hacemos fuera del ciclo
         var estudianteDao = new EstudianteDAO(); // esta instancia debe hacerse una vez
         while (!salir) {
             try {
                 mostrarMenu(); //Mostramos el menu
                 // Este sera el metodo ejecutarOpciones que devolvera un booleano
                 salir = ejecutarOpciones(consola, estudianteDao); // este arroja una excepcion
             } catch (Exception e) {
                 System.out.println("Ocurrió un error al ejecutar la operación: " + e.getMessage());
             }
             //Fin While
         }//Fin clase
     }

     private static void mostrarMenu() {
         System.out.print("""
                 ******* Sistema de Estudiantes *******
                 1. Listar Estudiante
                 2. Buscar Estudiante
                 3. Agregar Estudiante
                 4. Modificar Estudiante
                 5. Eliminar Estudiante
                 6. Salir
                 Elige una opcion: 
                 """);
     }

     //Método para ejecutar las opciones, va a regresar un valor booleano, ya que es el que
     //puede modificar el valor de la variable salir, si es verdadero termina el ciclo while
     private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch(opcion){
            case 1 -> { //Listar estudiantes
                System.out.println("Listado de Estudiantes...");
                //no muestra la información, solo recupera la info y regresa una lista
                var estudiantes = estudianteDAO.listarEstudiantes();//recibe el listado
                //vamos a iterar cada objeto de tipo estudiante
                estudiantes.forEach(System.out::println);//para imprimir la lista
            }//Fin caso 1
            case 2 -> { //Buscar estudiante por id
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if (encontrado)
                    System.out.println("Estudiante encontrado: "+estudiante);
                else
                    System.out.println("Estudiante NO encontrado: "+estudiante);
            }//Fin caso 2
            case 3 -> { //Agregar estudiante
                System.out.println("Agregar estudiante: ");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                //crear objeto estudiante (sin id)
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if (agregado)
                    System.out.println("Estudiante agregado: "+estudiante);
                else
                    System.out.println("Estudiante NO agregado: "+estudiante);

            }//fin caso 3
            case 4 -> { //Modificar estudiante
                System.out.println("Modificar estudiante: ");
                // Aqui lo primero es especificar cuál es el id del objeto a modificar
                System.out.println("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                //Crea el objeto estudiante a modificar
                var estudiante =
                        new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if(modificado)
                    System.out.println("Estudiante modificado: "+estudiante);
                else
                    System.out.println("Estudiante NO modificado: "+estudiante);
            }//Fin caso 4
            case 5-> { //Eliminar estudiante
                System.out.println("Eliminar estudiante: ");
                System.out.println("Id estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if(eliminado)
                    System.out.println("Estudiante eliminado: "+estudiante);
                else
                    System.out.println("Estudiante NO eliminado: "+estudiante);

            }//Fin caso 5
            case 6-> { //salir
                System.out.println("Adios!!!");
                salir = true;
            }//fin caso 6
            default -> System.out.println("Opcion no reconocida, ingrese otra opción");
        }//fin switch
         return salir;
      }
 }// Fin clase

