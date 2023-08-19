package UTN.presentacion;

import UTN.conexion.Conexion;
import UTN.datos.EstudianteDAO;
import com.google.protobuf.Syntax;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var conexion = Conexion.getConnection();
        if(conexion != null)
            System.out.println("Conexion exitosa: "+conexion);
            else
            System.out.println("Error al conectarse");

    }//Fin main

    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner (System.in); // para leer la informacion de la consola
        // se crea una instancia de la clase  servicio, esto lo hacemos fuera del ciclo
        var estudianteDao = new EstudianteDAO(); // esta instancia debe hacerse una vez
        while (!salir){
            try {
                mostrarMenu(); // Este sera  el metodo que devolvera un booleano
                salir = ejecutarOpciones(consola, estudianteDao); // Este arroja una excepcion
        } catch (Exception e){
                System.out.println("Ocurrió un error al ejecutar la operación: " + e.getMessage());
            }
        }
        //Fin del While

    }//Fin main
}//Fin clase