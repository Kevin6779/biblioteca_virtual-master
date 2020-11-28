package com.Biblioteca.Virtual.service.implementacion;

import com.Biblioteca.Virtual.models.entity.Libro;
import com.Biblioteca.Virtual.models.entity.Reserva;
import com.Biblioteca.Virtual.models.entity.Usuario;
import com.Biblioteca.Virtual.models.repository.LibroRepository;
import com.Biblioteca.Virtual.models.repository.ReservaRepository;
import com.Biblioteca.Virtual.models.repository.UsuarioRepository;
import com.Biblioteca.Virtual.service.iface.ReservaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService{
        @Autowired
    private ReservaRepository reservaRepository;
        @Autowired
        private UsuarioRepository usuarioRepository;
        @Autowired
        private LibroRepository libroRepository;
    @Override
    public List<Reserva> getAll() {
        List<Reserva> reservas = new ArrayList<>();
        reservaRepository.findAll().forEach(reservas::add);
        return reservas;
    }
    
     @Override
    public void create(Reserva reserva) {
        Optional<Usuario> usuario = usuarioRepository.findById(reserva.getUsuario().getCedula());
        Optional<Libro> libro = libroRepository.findById(reserva.getLibro().getId());
               if (usuario.isPresent() && libro.isPresent()) {
               reservaRepository.save(reserva);
        }
    }

    @Override
    public void update(int id, Reserva reserva) {
        // UPDATE movie set name='', description = '', ... WHERE id = 1;
        Optional<Reserva> existReserva = reservaRepository.findById(id);
        if (existReserva.isPresent()) {
            existReserva.get().setFechaIni(reserva.getFechaIni());
            existReserva.get().setFechaFin(reserva.getFechaFin());
          
            reservaRepository.save(existReserva.get());
        }
    }
    
      @Override
    public void delete(int id) {
        // DELETE FROM movie where id = 1;
        Optional<Reserva> existReserva = reservaRepository.findById(id);
        if (existReserva.isPresent()) {
            reservaRepository.delete(existReserva.get());
            // DELETE FROM movie
            // movieRepository.deleteAll();
        }
    }

    
}
