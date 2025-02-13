package org.example.mi_bocadillo_javafx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alergeno")
public class Alergeno {

    @Id
    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = true)
    private String descripcion;



    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}