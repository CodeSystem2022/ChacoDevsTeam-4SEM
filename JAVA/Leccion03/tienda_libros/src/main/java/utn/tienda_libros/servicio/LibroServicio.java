package utn.tienda_libros.servicio;

import org.springframework.stereotype.Service;

@Service

public class LibroServicio implements ILibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> listarLivros() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro buscarLibroPorId(Integer idLibro) {
        Libro libro = libroRepositorio.FindById(idLibro).orElse(null);
        return libro;
    }

    @Override
    public void guardarLibro(Libro libro) {
        libroRepositorio.save(libro);
    }

    @Override
    public void elminarLibro(Libro libro) {
        libroRepositorio.delete(libro);
    }
}
