package com.Biblioteca.Virtual.service.implementacion;

import com.Biblioteca.Virtual.models.entity.Genero;
import com.Biblioteca.Virtual.models.repository.GeneroRepository;
import com.Biblioteca.Virtual.service.iface.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class GeneroServiceImpl implements GeneroService {
    @Autowired
    private GeneroRepository generoRepository;
    @Override
    public List<Genero> getAll() {
        List<Genero> generos = new ArrayList<>();
        generoRepository.findAll().forEach(generos::add);
        return generos;
    }

}
