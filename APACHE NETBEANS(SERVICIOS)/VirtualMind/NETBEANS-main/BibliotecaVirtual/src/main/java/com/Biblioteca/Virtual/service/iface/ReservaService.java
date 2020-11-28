package com.Biblioteca.Virtual.service.iface;

import com.Biblioteca.Virtual.models.entity.Reserva;
import java.util.List;

public interface ReservaService {
    
    void create(Reserva reserva);
    
    List<Reserva> getAll();
    
    void update(int id, Reserva reserva);
    
    void delete(int id);
}
