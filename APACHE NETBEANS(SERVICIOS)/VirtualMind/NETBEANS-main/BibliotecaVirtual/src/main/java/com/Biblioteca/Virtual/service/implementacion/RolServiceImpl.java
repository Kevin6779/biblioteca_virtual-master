package com.Biblioteca.Virtual.service.implementacion;

import com.Biblioteca.Virtual.models.entity.Rol;
import com.Biblioteca.Virtual.models.repository.RolRepository;
import com.Biblioteca.Virtual.service.iface.RolService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService{
        @Autowired
    private RolRepository rolRepository;
    @Override
    public List<Rol> getAll() {
        List<Rol> rols = new ArrayList<>();
        rolRepository.findAll().forEach(rols::add);
        return rols;
    }
}
