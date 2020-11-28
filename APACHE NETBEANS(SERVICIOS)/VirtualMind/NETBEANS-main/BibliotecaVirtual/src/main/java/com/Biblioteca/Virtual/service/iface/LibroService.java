package com.Biblioteca.Virtual.service.iface;

import com.Biblioteca.Virtual.models.entity.Libro;
import java.util.List;

public interface LibroService {
    void create (Libro  libro);
    List<Libro> getAll();
    void update(int id,Libro libro);
    void delete (int id);
}
