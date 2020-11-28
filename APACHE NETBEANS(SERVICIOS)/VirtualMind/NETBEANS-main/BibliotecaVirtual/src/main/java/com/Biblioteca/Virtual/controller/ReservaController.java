package com.Biblioteca.Virtual.controller;

import com.Biblioteca.Virtual.models.entity.Reserva;
import com.Biblioteca.Virtual.service.iface.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")
@CrossOrigin("*")

public class ReservaController {
       @Autowired
    private ReservaService reservaService;
    @GetMapping
    public List<Reserva> getAll(){
        return reservaService.getAll();
    }
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create (@RequestBody Reserva reserva){
    reservaService.create(reserva);
    }
    
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Reserva reserva){
    reservaService.update(id, reserva);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
    reservaService.delete(id);
    }
}
