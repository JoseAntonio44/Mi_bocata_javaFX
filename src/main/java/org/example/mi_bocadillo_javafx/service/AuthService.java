package org.example.mi_bocadillo_javafx.service;

import org.example.mi_bocadillo_javafx.model.Usuario;
import org.example.mi_bocadillo_javafx.dao.UsuarioDAO;


public class AuthService {

    private static UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static boolean validarCredenciales(String email, String password) {
        Usuario usuario = usuarioDAO.obtenerUsuarioPorEmail(email);
        return usuario != null && usuario.getPassword().equals(password);
    }
}
