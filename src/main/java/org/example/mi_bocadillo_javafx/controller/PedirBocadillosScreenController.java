package org.example.mi_bocadillo_javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import org.example.mi_bocadillo_javafx.service.BocadilloService;

import java.net.URL;
import java.util.ResourceBundle;

public class PedirBocadillosScreenController implements Initializable {
    @FXML
    private Text bocataFrio;

    @FXML
    private Text bocataCaliente;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarBocadillos();
    }

    private void mostrarBocadillos(){
        BocadilloService bocadilloService = new BocadilloService();
        bocataFrio.setText(bocadilloService.obtenerBocataFrio().getNombre());
        bocataCaliente.setText(bocadilloService.obtenerBocataCaliente().getNombre());
    }


}
