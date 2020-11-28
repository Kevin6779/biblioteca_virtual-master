package com.Biblioteca.Virtual.service.implementacion;

import com.Biblioteca.Virtual.models.entity.Rol;
import com.Biblioteca.Virtual.models.entity.Usuario;
import com.Biblioteca.Virtual.models.repository.RolRepository;
import com.Biblioteca.Virtual.models.repository.UsuarioRepository;
import com.Biblioteca.Virtual.service.iface.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
     @Autowired
    private RolRepository rolRepository;
    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuarios::add);
        return usuarios;
    }
    @Override
    public void create(Usuario usuario) {
       Optional<Rol> rol = rolRepository.findById(usuario.getRol().getId());

        if(rol.isPresent())
        {
            usuarioRepository.save(usuario);
        }
    }

    @Override
    public void update(int id, Usuario usuario) {
         Optional<Usuario> existUser = usuarioRepository.findById(id);
        if(existUser.isPresent())
        {
            existUser.get().setNombre(usuario.getNombre());
            existUser.get().setEdad(usuario.getEdad());
            existUser.get().setEmail(usuario.getEmail());
            existUser.get().setUsuario(usuario.getUsuario());
            existUser.get().setPassword(usuario.getPassword());
            existUser.get().setCedula(usuario.getCedula());
              Optional<Rol> rol = rolRepository.findById(usuario.getRol().getId());
            if (rol.isPresent()) {
                existUser.get().setRol(rol.get());
            }
            usuarioRepository.save(existUser.get());
        }
    }

    @Override
    public void delete(int id) {
        //DELETE FROM USER WHERE ID=
         Optional<Usuario> existUser = usuarioRepository.findById(id);
         if(existUser.isPresent())
        {
          usuarioRepository.delete(existUser.get());
        }
    }
 
}
