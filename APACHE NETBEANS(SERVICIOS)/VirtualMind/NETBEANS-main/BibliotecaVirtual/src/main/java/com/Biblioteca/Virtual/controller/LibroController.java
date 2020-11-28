package com.Biblioteca.Virtual.controller;

import com.Biblioteca.Virtual.models.entity.Libro;
import com.Biblioteca.Virtual.service.iface.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/libro")
@CrossOrigin("*")
public class LibroController {
    @Autowired
    private LibroService libroService;
    @GetMapping
    public List<Libro> getAll(){
        return libroService.getAll();
    }
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Libro libro){
    libroService.create(libro);
    }
    
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody Libro libro){
    libroService.update(id, libro);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
    libroService.delete(id);
    }
}
