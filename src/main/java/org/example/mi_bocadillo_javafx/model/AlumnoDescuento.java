package org.example.mi_bocadillo_javafx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alumno_descuento")
public class AlumnoDescuento {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_descuento", nullable = false)
    private Descuento descuento;

    // Getters y Setters

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }
}
