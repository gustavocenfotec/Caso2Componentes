package com.cenfotec.elgillitofeliz.repository;

import com.cenfotec.elgillitofeliz.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query(value="Select li from Libro li where li.titulo LIKE %:titulo% order by li.id")

    List<Libro> findTitulo (@Param("titulo")String titulo);


}
