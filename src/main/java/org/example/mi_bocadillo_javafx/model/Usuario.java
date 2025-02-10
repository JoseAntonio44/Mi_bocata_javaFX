package org.example.mi_bocadillo_javafx.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 255, name = "password")
    private String password;

    // Constructor vacío requerido por JPA
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", password='[PROTECTED]'" +  // Evita mostrar la contraseña en logs
                '}';
    }
}