package org.example.mi_bocadillo_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
        loginButton.setOnAction(event -> {
            // Cerrar la ventana actual
            loginButton.getScene().getWindow().hide();

            // Abrir una nueva ventana
            abrirNuevaVentana();
        });
    }

    private void abrirNuevaVentana() {
        LoginApplication.mostrarPantallaPrincipal();
    }
}
