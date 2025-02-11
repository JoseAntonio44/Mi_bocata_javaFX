package org.example.mi_bocadillo_javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.mi_bocadillo_javafx.MainApplication;
import org.example.mi_bocadillo_javafx.service.UsuarioService;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField emailField;


    @FXML
    private PasswordField passwordField;


    @FXML
    private Label mensajeLabel;



    @FXML
    private void manejarLogin() {
        UsuarioService usuarioService = new UsuarioService();
        if (usuarioService.validarCredenciales(emailField.getText(), passwordField.getText())) {
            MainApplication.mostrarPantallaPrincipal();
        }else {
            mostrarMensaje("Error", "Credenciales inválidas", Alert.AlertType.ERROR);
        }
    }


    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
