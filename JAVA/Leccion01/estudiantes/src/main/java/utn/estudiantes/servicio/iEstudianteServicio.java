package utn.estudiantes.servicio;

import utn.estudiantes.modelo.Estudiante;

import java.util.List;
public interface iEstudianteServicio {
    public List<Estudiante> ListarEstudiantes();
    public  Estudiante buscarEstudaintePorId(Integer idEstudainte);
    public  void guardarEstudiante(Estudiante estudiante);
    public  void eliminarEstudiante(Estudiante estudiante);
}
