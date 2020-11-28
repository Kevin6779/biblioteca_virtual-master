package com.Biblioteca.Virtual.models.repository;

import com.Biblioteca.Virtual.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
}
