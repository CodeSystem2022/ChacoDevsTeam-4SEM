 package UTN.presentacion;

import UTN.conexion.Conexion;
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
        var consola = new Scanner(System.in); // Para leer informacion de la consola
        // se crea una instancia de la clase servicio , esto lo hacemos fuera del ciclo
        var estudianteDao = new EstudianteDAO(); // esta instancia debe hacerse una vez
        while (!salir){
            try{
            mostrarMenu(); //Mostramos el menu
            // Este sera el metodo ejecutarOpciones que devolvera un booleano
            salir = ejecutarOpciones(consola, estudianteDao); // este arroja una excepcion
        } catch(Exception e){
            System.out.println("Ocurrió un error al ejecutar la operación: " +e.getMessage());
        }
        //Fin While
}//Fin clase


    private static void mostrarMenu(){
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