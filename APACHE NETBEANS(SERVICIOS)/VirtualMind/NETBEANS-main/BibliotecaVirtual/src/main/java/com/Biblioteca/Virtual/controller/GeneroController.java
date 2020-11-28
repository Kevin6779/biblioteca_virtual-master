package com.Biblioteca.Virtual.controller;

import com.Biblioteca.Virtual.models.entity.Genero;
import com.Biblioteca.Virtual.service.iface.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    private GeneroService generoService;
    @GetMapping
    public List<Genero> getAll(){
        return generoService.getAll();
    }
}
