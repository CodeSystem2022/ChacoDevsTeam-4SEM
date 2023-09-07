package utn.estudiantes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.estudiantes.modelo.Estudiante;
import utn.estudiantes.repositorio.EstudianteRepositorio;

import java.util.List;
@Service
public class EstudianteServicio implements  iEstudianteServicio{
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Override
    public List<Estudiante> ListarEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepositorio.findAll();
        return estudiantes;
    }

    @Override
    public Estudiante buscarEstudaintePorId(Integer idEstudainte) {
        Estudiante estudiante = estudianteRepositorio.findById(idEstudainte).orElse(null);
        return estudiante;
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {

    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {

    }
}
