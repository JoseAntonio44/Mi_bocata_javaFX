package org.example.mi_bocadillo_javafx.service;
import org.example.mi_bocadillo_javafx.dao.UsuarioDAO;
import org.example.mi_bocadillo_javafx.model.Usuario;


public class AuthService {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    public boolean login(String email, String password) {
        Usuario usuario = usuarioDAO.validarCredenciales(email, password);
        return usuario != null; // Devuelve `true` si el login es correcto
    }

}
