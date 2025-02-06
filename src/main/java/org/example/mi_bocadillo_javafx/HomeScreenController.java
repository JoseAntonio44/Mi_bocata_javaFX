package org.example.mi_bocadillo_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            cargarPantallaPedirBocadillos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
