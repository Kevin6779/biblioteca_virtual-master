package com.Biblioteca.Virtual.models.repository;

import com.Biblioteca.Virtual.models.entity.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends CrudRepository<Libro, Integer> {
}
