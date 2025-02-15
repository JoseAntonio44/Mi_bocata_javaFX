package org.example.mi_bocadillo_javafx.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bocadillo")
public class Bocadillo {

    @Id
    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "f_baja", nullable = true)
    private Date fBaja;

    @Column(name = "ingredientes", columnDefinition = "TEXT", nullable = true)
    private String ingredientes;

    @Column(name = "pvp", precision = 10, scale = 2, nullable = true)
    private BigDecimal pvp;

    @Enumerated(EnumType.STRING)
    @Column(name = "frio", nullable = true)
    private TipoBocadillo frio;

    @ManyToOne
    @JoinColumn(name = "id_alergeno", referencedColumnName = "nombre", nullable = true)
    private Alergeno alergeno;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia", nullable = true)
    private DiaSemana dia;


    @OneToMany(mappedBy = "bocadillo", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public TipoBocadillo getFrio() {
        return frio;
    }

    public void setFrio(TipoBocadillo frio) {
        this.frio = frio;
    }

    public Alergeno getAlergeno() {
        return alergeno;
    }

    public void setAlergeno(Alergeno alergeno) {
        this.alergeno = alergeno;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Date getfBaja() {
        return fBaja;
    }
    public void setfBaja(Date fBaja) {
        this.fBaja = fBaja;
    }

    public enum TipoBocadillo {
        Frio, Caliente
    }

    public enum DiaSemana {
        Lunes, Martes, Miercoles, Jueves, Viernes, Sabado
    }
}