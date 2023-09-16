package utn.estudiantes.servicio;

import utn.estudiantes.modelo.Estudiante2022;

import java.util.List;
public interface iEstudianteServicio {
    public List<Estudiante2022> ListarEstudiantes();
    public Estudiante2022 buscarEstudaintePorId(Integer idEstudainte);
    public  void guardarEstudiante(Estudiante2022 estudiante2022);
    public  void eliminarEstudiante(Estudiante2022 estudiante2022);
}
