package org.example.mi_bocadillo_javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.example.mi_bocadillo_javafx.auth.AuthManager;
import org.example.mi_bocadillo_javafx.model.Usuario;
import org.example.mi_bocadillo_javafx.service.BocadilloService;
import org.example.mi_bocadillo_javafx.service.PedidoService;

import java.net.URL;
import java.util.ResourceBundle;

public class PedirBocadillosScreenController implements Initializable {
    @FXML
    private Text bocataFrio;

    @FXML
    private Text bocataCaliente;

    @FXML
    private Text labelMensaje;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarBocadillos();
    }

    private void mostrarBocadillos(){
        BocadilloService bocadilloService = new BocadilloService();
        bocataFrio.setText(bocadilloService.obtenerNombreBocataFrio());
        bocataCaliente.setText(bocadilloService.obtenerNombreBocataCaliente());
    }

    @FXML
    private void pedirBocadilloFrio() {
        PedidoService pedidoService = new PedidoService();
        String mensaje = pedidoService.guardarPedido(true);
        System.out.println(mensaje);
        labelMensaje.setText(mensaje);
    }

    @FXML
    private void pedirBocadilloCaliente() {
        PedidoService pedidoService = new PedidoService();
        String mensaje = pedidoService.guardarPedido(false);
        System.out.println(mensaje);
        labelMensaje.setText(mensaje);
    }






}
