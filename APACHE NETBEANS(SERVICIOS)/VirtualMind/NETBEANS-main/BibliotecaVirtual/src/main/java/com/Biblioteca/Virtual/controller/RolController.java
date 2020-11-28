package com.Biblioteca.Virtual.controller;

import com.Biblioteca.Virtual.models.entity.Rol;
import com.Biblioteca.Virtual.service.iface.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
public class RolController {
     @Autowired
    private RolService rolService;
    @GetMapping
    public List<Rol> getAll(){
        return rolService.getAll();
    }
}
