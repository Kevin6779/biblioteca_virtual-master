
package com.Biblioteca.Virtual.models.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_reserva")
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cedula")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_libro")
    private Libro libro;
    @Column(name = "fecha_inicio")
    private LocalDate fechaIni;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Usuario getUsuario() { return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
       public Libro getLibro() { return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
     public LocalDate getFechaIni() {
        return fechaIni;
    }
    
    public void setFechaIni(LocalDate fechaIni){
    this.fechaIni = fechaIni;
    }
    
      public LocalDate getFechaFin() {
        return fechaFin;
    }
    
    public void setFechaFin(LocalDate fechaFin){
    this.fechaFin = fechaFin;
    }
    
}
