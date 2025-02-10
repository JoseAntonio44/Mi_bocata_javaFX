package org.example.mi_bocadillo_javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.mi_bocadillo_javafx.MainApplication;
import org.example.mi_bocadillo_javafx.service.LoginService;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField emailField;


    @FXML
    private PasswordField passwordField;


    @FXML
    private Label mensajeLabel;

    private LoginService loginService = new LoginService();


    @FXML
    private void manejarLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (loginService.validarCredenciales(email, password)) {
            mostrarMensaje("Login exitoso", "¡Bienvenido!", Alert.AlertType.INFORMATION);
            MainApplication.mostrarPantallaPrincipal();
        } else {
            mostrarMensaje("Error de login", "Usuario o contraseña incorrectos", Alert.AlertType.ERROR);
        }
    }


    private void mostrarMensaje(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
