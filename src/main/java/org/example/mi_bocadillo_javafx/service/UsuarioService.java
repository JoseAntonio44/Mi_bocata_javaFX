package org.example.mi_bocadillo_javafx.service;


import org.example.mi_bocadillo_javafx.dao.UsuarioDAO;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean validarCredenciales(String email, String password) {
        if(usuarioDAO.getAlumnoByEmail(email, password) != null) {
            return true;
        }else {
            return false;
        }
    }
}