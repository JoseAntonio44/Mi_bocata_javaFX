package org.example.mi_bocadillo_javafx.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "f_baja")
    private Date fBaja;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Alumno> alumnos;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getfBaja() {
        return fBaja;
    }

    public void setfBaja(Date fBaja) {
        this.fBaja = fBaja;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
