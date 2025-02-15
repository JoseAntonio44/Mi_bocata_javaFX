package org.example.mi_bocadillo_javafx.service;


import org.example.mi_bocadillo_javafx.auth.AuthManager;
import org.example.mi_bocadillo_javafx.dao.UsuarioDAO;
import org.example.mi_bocadillo_javafx.model.Usuario;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean validarCredenciales(String email, String password) {
        Usuario usuario = usuarioDAO.getUsuarioByEmail(email, password);

        if (usuario != null) {
            AuthManager.getInstance().login(usuario);
            return true;
        } else {
            return false;
        }
    }
}