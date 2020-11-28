package com.Biblioteca.Virtual.controller;

import com.Biblioteca.Virtual.models.entity.Usuario;
import com.Biblioteca.Virtual.service.iface.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public List<Usuario> getAll() {
        return usuarioService.getAll();
    }
    @PostMapping
    public void create(@RequestBody Usuario usuario)
    {
        usuarioService.create(usuario);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        usuarioService.delete(id);
    }
     @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Usuario usuario){
        usuarioService.update(id,usuario);
    }
}
