package com.Biblioteca.Virtual.service.iface;

import com.Biblioteca.Virtual.models.entity.Usuario;
import java.util.List;

public interface UsuarioService {
    void create (Usuario usuario);
    List<Usuario>getAll();
    void update(int id,Usuario usuario);
    void delete (int id);
}
