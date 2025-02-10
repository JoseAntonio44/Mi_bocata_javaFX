package org.example.mi_bocadillo_javafx.service;


import org.example.mi_bocadillo_javafx.dao.UsuarioDAO;
import org.example.mi_bocadillo_javafx.model.Usuario;

public class LoginService {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean validarCredenciales(String email, String password) {
        Usuario usuario = usuarioDAO.obtenerPorEmail(email);
        return usuario != null && usuario.getPassword().equals(password);
    }
}
