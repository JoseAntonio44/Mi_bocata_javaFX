package org.example.mi_bocadillo_javafx.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_bocadillo", nullable = false)
    private Bocadillo bocadillo;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "f_recogido")
    private Date fRecogido;

    @Column(name = "pvp", precision = 10, scale = 2)
    private BigDecimal pvp;

    @ManyToOne
    @JoinColumn(name = "id_descuento")
    private Descuento descuento;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Bocadillo getBocadillo() {
        return bocadillo;
    }

    public void setBocadillo(Bocadillo bocadillo) {
        this.bocadillo = bocadillo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getfRecogido() {
        return fRecogido;
    }

    public void setfRecogido(Date fRecogido) {
        this.fRecogido = fRecogido;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }
}
