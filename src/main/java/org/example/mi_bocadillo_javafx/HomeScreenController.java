package org.example.mi_bocadillo_javafx;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class HomeScreenController {

    @FXML
    private AnchorPane contenidoPrincipal;

    private void cargarPantalla(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/mi_bocadillo_javafx/"+fxml));
        AnchorPane pantalla = loader.load();  // Cargar la nueva pantalla
        contenidoPrincipal.getChildren().setAll(pantalla);  // Reemplazar el contenido principal
    }

    @FXML
    private void cargarPantallaPedirBocadillos() throws IOException {
        cargarPantalla("pedir-bocadillos-screen.fxml");
    }
    @FXML
    private void cargarPantallaBocadillos() throws IOException {
        cargarPantalla("lista-bocadillos-screen.fxml");
    }
}
