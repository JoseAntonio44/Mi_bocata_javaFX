package org.example.mi_bocadillo_javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.mi_bocadillo_javafx.MainApplication;
import org.example.mi_bocadillo_javafx.auth.AuthManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeScreenController implements Initializable {

    @FXML
    private VBox contenidoPrincipal;

    private void cargarPantalla(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mi_bocadillo_javafx/" + fxml));
        AnchorPane pantalla = loader.load();
        contenidoPrincipal.getChildren().setAll(pantalla);
    }

    @FXML
    private void cargarPantallaPedirBocadillos() throws IOException {
        cargarPantalla("pedir-bocadillos-screen.fxml");
    }

    @FXML
    private void cargarPantallaBocadillos() throws IOException {
        cargarPantalla("lista-bocadillos-screen.fxml");
    }
    @FXML
    private void cargarPantallaPedidos() throws IOException {
        cargarPantalla("pedidos-screen.fxml");
    }

    @FXML
    private void cerrarSesion() throws IOException {
        AuthManager.getInstance().logout();

        // Cerrar la ventana actual
        Stage stage = (Stage) contenidoPrincipal.getScene().getWindow();
        stage.close();

        // Mostrar el login
        MainApplication.mostrarLogin();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            cargarPantallaPedirBocadillos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
