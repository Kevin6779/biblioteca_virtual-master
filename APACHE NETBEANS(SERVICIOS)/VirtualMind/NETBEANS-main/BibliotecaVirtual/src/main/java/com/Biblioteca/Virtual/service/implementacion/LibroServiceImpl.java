package com.Biblioteca.Virtual.service.implementacion;

import com.Biblioteca.Virtual.models.entity.Genero;
import com.Biblioteca.Virtual.models.entity.Libro;
import com.Biblioteca.Virtual.models.repository.GeneroRepository;
import com.Biblioteca.Virtual.models.repository.LibroRepository;
import com.Biblioteca.Virtual.service.iface.LibroService;
import static java.lang.Integer.parseInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository libroRepository;
     @Autowired
    private GeneroRepository generoRepository;
    @Override
    public List<Libro> getAll() {
        List<Libro> libros = new ArrayList<>();
        libroRepository.findAll().forEach(libros::add);
        return libros;
    }

    @Override
    public void create(Libro libro) {
        Optional<Genero> genero = generoRepository.findById(libro.getGenero().getId());
        if(genero.isPresent())
        {
            libroRepository.save(libro);
        }
    }

    @Override
    public void update(int id, Libro libro) {
        Optional<Libro>existsBook = libroRepository.findById(id);
        if(existsBook.isPresent())
        {
            existsBook.get().setAutor(libro.getAutor());
            existsBook.get().setDiponibilidad(libro.getDisponibilidad());
            existsBook.get().setGenero(libro.getGenero());
            existsBook.get().setId(libro.getId());
            existsBook.get().setNombre(libro.getNombre());
            existsBook.get().setPaginas(libro.getPaginas());
            existsBook.get().setPublicacion(libro.getPublicacion());
            Optional<Genero> genero = generoRepository.findById(libro.getGenero().getId());
            if (genero.isPresent()) {
                existsBook.get().setGenero(genero.get());
            }
            libroRepository.save(existsBook.get());
        }
    }

    @Override
    public void delete(int id) {
          Optional<Libro>existsBook = libroRepository.findById(id);
         if(existsBook.isPresent())
        {
          libroRepository.delete(existsBook.get());
        }
    }
}
