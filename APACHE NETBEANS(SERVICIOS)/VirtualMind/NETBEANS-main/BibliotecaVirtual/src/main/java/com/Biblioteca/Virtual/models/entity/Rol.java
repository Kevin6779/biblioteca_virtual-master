package com.Biblioteca.Virtual.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @Column(name = "rol_id")
    private int id;
    @Column(name = "rol_usuario")
    private String usuario;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id){
    this.id = id;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
}
