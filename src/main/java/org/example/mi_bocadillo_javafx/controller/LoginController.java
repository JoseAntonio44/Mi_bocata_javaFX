package org.example.mi_bocadillo_javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.mi_bocadillo_javafx.MainApplication;
import org.example.mi_bocadillo_javafx.service.AuthService;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField emailField;


    @FXML
    private PasswordField passwordField;


    @FXML
    private Label mensajeLabel;



    /*@FXML
    public void initialize() {
        loginButton.setOnAction(event -> {

            String email = emailField.getText();
            String password = passwordField.getText();

            if(AuthService.login(email,password)){
                loginButton.getScene().getWindow().hide();
                abrirNuevaVentana();
            }else {
                mensajeLabel.setText("Email o contraseña incorrecto");
            }

        });
    }*/

    private final AuthService authService = new AuthService();

    @FXML
    public void onLoginButtonClicked() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (authService.login(email, password)) {
            mensajeLabel.setText("Login exitoso");
            loginButton.getScene().getWindow().hide();
            abrirNuevaVentana();
            // Aquí puedes redirigir a la siguiente pantalla
        } else {
            mensajeLabel.setText("Credenciales incorrectas");
        }
    }

    private void abrirNuevaVentana() {
        MainApplication.mostrarPantallaPrincipal();
    }
}
