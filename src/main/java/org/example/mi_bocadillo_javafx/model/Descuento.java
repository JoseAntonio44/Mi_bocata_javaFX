package org.example.mi_bocadillo_javafx.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "descuento")
public class Descuento {

    @Id
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "f_baja")
    private Date fBaja;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "importe", precision = 10, scale = 2)
    private BigDecimal importe;

    @Column(name = "porcentaje", precision = 5, scale = 2)
    private BigDecimal porcentaje;


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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
}
