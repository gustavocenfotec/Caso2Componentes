package com.cenfotec.elgillitofeliz.services;

import com.cenfotec.elgillitofeliz.entities.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {

    List<Libro> findAll();
    List<Libro> findAll(String titulo);
    Optional<Libro> getById(Long id);
    Libro create(String nombre, String titulo, String nombreAutor,
                   int edicion, int annoPublicacion,int cantidadPaginas);
    void update(Libro libro);
    Boolean delete(Long id);
}
