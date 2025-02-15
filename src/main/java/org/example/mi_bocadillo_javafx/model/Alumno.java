package org.example.mi_bocadillo_javafx.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "motivo", length = 255)
    private String motivo;

    @Temporal(TemporalType.DATE)
    @Column(name = "f_baja")
    private Date fBaja;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @Enumerated(EnumType.STRING)
    @Column(name = "abonado", nullable = false)
    private Abonado abonado;

    @ManyToOne
    @JoinColumn(name = "id_descuento")
    private Descuento descuento;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getfBaja() {
        return fBaja;
    }

    public void setfBaja(Date fBaja) {
        this.fBaja = fBaja;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Abonado getAbonado() {
        return abonado;
    }

    public void setAbonado(Abonado abonado) {
        this.abonado = abonado;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public enum Abonado {
        si, no
    }

}
