package org.example.mi_bocadillo_javafx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 255, unique = true, name = "email")
    private String email;

    @Column(nullable = false, length = 255, name = "password")
    private String password;

    @Column(length = 255, unique = true, name = "mac")
    private String mac;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;

    public enum TipoUsuario {
        Cocina, Administrador
    }

    // Constructor vacío requerido por JPA
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String email, String password, String mac, TipoUsuario tipoUsuario) {
        this.email = email;
        this.password = password;
        this.mac = mac;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", mac='" + mac + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", password='[PROTECTED]'" +  // Evita mostrar la contraseña en logs
                '}';
    }
}