package org.example.mi_bocadillo_javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.example.mi_bocadillo_javafx.auth.AuthManager;
import org.example.mi_bocadillo_javafx.model.Usuario;
import org.example.mi_bocadillo_javafx.service.PedidoService;

import java.net.URL;
import java.util.ResourceBundle;

public class CocinaPedidosController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarPedidos();
    }

    private final PedidoService pedidoService = new PedidoService();
    Usuario usuario = AuthManager.getInstance().getUsuarioActual();


    @FXML
    private VBox listaPedidos;


    public void mostrarPedidos(){
        pedidoService.obtenerPedidosHoyNoRecogidos().forEach(pedido -> {
            HBox tarjeta = crearTarjeta(
                    pedido.getBocadillo().getNombre(), //nombreBocadillo
                    pedido.getFecha().toString()); //fecha

            listaPedidos.getChildren().add(tarjeta);
        });
    }

    public static HBox crearTarjeta(String nombreBocadillo, String fecha) {
        //Contenedor de la tarjeta
        HBox tarjeta = new HBox(10);

        //Elementos dentro de la tarjeta
        Label labelNombre = new Label("Bocadillo: " + nombreBocadillo);
        labelNombre.setFont(Font.font(16));

        Label labelFecha = new Label("Fecha: " + fecha);
        labelFecha.setFont(Font.font(14));

        Button buttonRecoger = new Button("Recoger");
        //TODO poner funcion recoger pedido al pulsar el boton

        //Elementos al contenedor
        tarjeta.getChildren().addAll(labelNombre, labelFecha);

        tarjeta.setStyle("-fx-background-color: #f4f4f4; -fx-padding: 10; -fx-border-radius: 10; -fx-effect: dropshadow(three-pass-box, gray, 10, 0.5, 0, 0)");

        return tarjeta;
    }


}
