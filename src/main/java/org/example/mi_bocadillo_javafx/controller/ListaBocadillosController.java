package org.example.mi_bocadillo_javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import org.example.mi_bocadillo_javafx.model.Bocadillo;
import org.example.mi_bocadillo_javafx.service.BocadilloService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListaBocadillosController implements Initializable {
    @FXML
    private ListView<Bocadillo> listaBocadillos;


    BocadilloService bocadilloService = new BocadilloService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaBocatas();
        configurarListView();

        listaBocadillos.getStylesheets().add(getClass().getResource("/org/example/mi_bocadillo_javafx/style.css").toExternalForm());
    }

    private void listaBocatas() {
        List<Bocadillo> bocadillos = bocadilloService.mostrarListaBocadillos();
        listaBocadillos.getItems().addAll(bocadillos);
    }

    private void configurarListView() {
        listaBocadillos.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Bocadillo bocadillo, boolean empty) {
                super.updateItem(bocadillo, empty);
                if (empty || bocadillo == null) {
                    setText(null);
                    setGraphic(null);
                } else {

                    HBox hBox = new HBox(10);
                    hBox.setStyle("-fx-padding: 10; -fx-background-color: #191919; -fx-border-radius: 10; -fx-background-radius: 10;");

                    Label diaLabel = new Label(bocadillo.getDia().name());
                    diaLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");

                    Label nombreLabel = new Label(bocadillo.getNombre());
                    nombreLabel.setStyle("-fx-text-fill: white;");

                    Region espacio = new Region();
                    HBox.setHgrow(espacio, Priority.ALWAYS);

                    hBox.getChildren().addAll(diaLabel, espacio, nombreLabel);

                    setStyle("-fx-background-color: black;");
                    setGraphic(hBox);
                }
            }
        });
    }

}
