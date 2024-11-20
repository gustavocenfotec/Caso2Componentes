package com.cenfotec.elgillitofeliz.services.implementation;

import com.cenfotec.elgillitofeliz.entities.Libro;
import com.cenfotec.elgillitofeliz.repository.LibroRepository;
import com.cenfotec.elgillitofeliz.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LibroImpl implements LibroService {

    @Autowired
    private  LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() {
        return this.libroRepository.findAll();
    }

    @Override
    public List<Libro> findAll(String titulo) {
            return libroRepository.findTitulo(titulo);
    }

    @Override
    public Optional<Libro> getById(Long id) {
        return this.libroRepository.findById(id);
    }

    @Override
    public Libro create(String nombre, String titulo, String nombreAutor,
                        int edicion, int annoPublicacion, int cantidadPaginas) {
        Libro libro = new Libro();
        libro.setNombre(nombre);
        libro.setTitulo(titulo);
        libro.setNombreAutor(nombreAutor);
        libro.setEdicion(edicion);
        libro.setAnnoPublicacion(annoPublicacion);
        libro.setCantidadPaginas(cantidadPaginas);
        return this.libroRepository.save(libro);
    }

    @Override
    public void update(Libro libro) {
        this.libroRepository.save(libro);

    }

    @Override
    public Boolean delete(Long id) {
        this.libroRepository.deleteById(id);
        return true;
    }
}
