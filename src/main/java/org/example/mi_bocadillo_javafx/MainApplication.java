package org.example.mi_bocadillo_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class MainApplication extends Application {
    public static Stage primaryStage;
    private static Stage loginStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        mostrarLogin();
    }

    public static void mostrarLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(loader.load(), 650, 650);
        loginStage = new Stage();
        loginStage.setScene(scene);
        loginStage.initStyle(StageStyle.TRANSPARENT);
        loginStage.setResizable(false);
        loginStage.show();
    }

    public static void mostrarPantallaPrincipal() {
        try {
            if (loginStage != null) {
                loginStage.close();
            }
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("home-screen.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Pantalla Principal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}