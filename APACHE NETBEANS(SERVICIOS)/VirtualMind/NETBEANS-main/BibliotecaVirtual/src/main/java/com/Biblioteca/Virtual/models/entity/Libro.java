    package com.Biblioteca.Virtual.models.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "autor")
    private String autor;
    @Column(name = "anio_publicacion")
    private LocalDate publicacion;
    @Column(name = "cant_paginas")
    private int paginas;
    //@ManyToMany(fetch = FetchType.EAGER) // malo
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genero")
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // malo
    private Genero genero;
    @Column(name = "diponibilidad")
    private boolean diponibilidad; // true o false

    public boolean getDisponibilidad() {
        return diponibilidad;
    }

    public void setDiponibilidad(boolean diponibilidad) {
        this.diponibilidad = diponibilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(LocalDate publicacion) {
        this.publicacion = publicacion;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public Genero getGenero() { return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
