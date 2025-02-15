package org.example.mi_bocadillo_javafx.auth;

import org.example.mi_bocadillo_javafx.model.Usuario;

public class AuthManager {
    private static AuthManager instance;
    private Usuario usuarioActual;

    private AuthManager() {
    }

    public static AuthManager getInstance() {
        if (instance == null) {
            instance = new AuthManager();
        }
        return instance;
    }

    public void login(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    public void logout() {
        this.usuarioActual = null;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public boolean isLoggedIn() {
        return usuarioActual != null;
    }
}
