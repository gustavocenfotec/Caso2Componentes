package com.cenfotec.elgillitofeliz.graphql;


import com.cenfotec.elgillitofeliz.entities.Libro;
import com.cenfotec.elgillitofeliz.services.LibroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;



import java.util.List;

@Controller
public class LibroController {

    Logger logger = LoggerFactory.getLogger(LibroController.class);


    @Autowired
    private LibroService libroService;

    @QueryMapping
    public List<Libro> getLibros(){
        return libroService.findAll();
    }

    @QueryMapping
    public List<Libro> getLibrosTitulo(
            @Argument String titulo
    ) {

        List<Libro> libros = libroService.findAll(titulo);
        return libros;
    }

    @QueryMapping
    public Libro getLibro(@Argument long id) {
        return libroService.getById(id).orElse(null);
    }

    @MutationMapping
    public Libro createLibro(@Argument String nombre,
                                 @Argument String titulo,
                                 @Argument String nombreAutor,
                                 @Argument int annoPublicacion,
                                 @Argument int edicion,
                                 @Argument int cantidadPaginas) {
        return this.libroService.create(nombre, titulo, nombreAutor,
                annoPublicacion,edicion,cantidadPaginas);
    }

    @MutationMapping
    public Boolean deleteLibro(@Argument long id) {
        return this.libroService.delete(id);
    }

    @MutationMapping
    public Libro updateLibro(@Argument long id,
                             @Argument String nombre,
                             @Argument String titulo,
                             @Argument String nombreAutor,
                             @Argument int annoPublicacion,
                             @Argument int edicion,
                             @Argument int cantidadPaginas) {
        Libro libro = this.libroService.getById(id).orElse(null);
        if (libro != null) {
            libro.setNombre(nombre);
            libro.setTitulo(titulo);
            libro.setNombreAutor(nombreAutor);
            libro.setEdicion(edicion);
            libro.setAnnoPublicacion(annoPublicacion);
            libro.setCantidadPaginas(cantidadPaginas);
            this.libroService.update(libro);
        }
        return libro;
    }
}
