package utn.estudiantes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.estudiantes.modelo.Estudiante2022;
import utn.estudiantes.repositorio.EstudianteRepositorio;

import java.util.List;
@Service
public class EstudianteServicio implements  iEstudianteServicio{
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Override
    public List<Estudiante2022> ListarEstudiantes() {
        List<Estudiante2022> estudiante2022s = estudianteRepositorio.findAll();
        return estudiante2022s;
    }

    @Override
    public Estudiante2022 buscarEstudaintePorId(Integer idEstudainte) {
        Estudiante2022 estudiante2022 = estudianteRepositorio.findById(idEstudainte).orElse(null);
        return estudiante2022;
    }

    @Override
    public void guardarEstudiante(Estudiante2022 estudiante2022) {
        estudianteRepositorio.save(estudiante2022);
    }

    @Override
    public void eliminarEstudiante(Estudiante2022 estudiante2022) {
        estudianteRepositorio.delete(estudiante2022);
    }
}
