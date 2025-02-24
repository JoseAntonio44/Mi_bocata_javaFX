package org.example.mi_bocadillo_javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class PedidosController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarPedidos();
    }
    PedidoService pedidoService = new PedidoService();
    Usuario usuario = AuthManager.getInstance().getUsuarioActual();


    @FXML
    private VBox listaPedidos;

    public void mostrarPedidos(){
        pedidoService.obtenerPedidosPorAlumno(usuario.getEmail()).forEach(pedido -> {
            HBox tarjeta = crearTarjeta(
                    pedido.getBocadillo().getNombre(), //nombreBocadillo
                    pedido.getF_recogido() == null ? "Pendiente" : "Recogido", //estado
                    pedido.getFecha().toString()); //fecha

            listaPedidos.getChildren().add(tarjeta);
        });
    }

    public static HBox crearTarjeta(String nombreBocadillo, String estado, String fecha) {
        //Contenedor de la tarjeta
        HBox tarjeta = new HBox(10);

        //Elementos dentro de la tarjeta
        Label labelNombre = new Label("Bocadillo: " + nombreBocadillo);
        labelNombre.setFont(Font.font(16));
        labelNombre.setTextFill(Color.WHITE);

        Label labelEstado = new Label("Estado: " + estado);
        labelEstado.setFont(Font.font(14));
        labelEstado.setTextFill(estado.equals("Pendiente") ? Color.RED : Color.GREEN);

        Label labelFecha = new Label("Fecha: " + fecha);
        labelFecha.setFont(Font.font(14));
        labelFecha.setTextFill(Color.WHITE);

        //Elementos al contenedor
        tarjeta.getChildren().addAll(labelNombre, labelEstado, labelFecha);

        tarjeta.setStyle("-fx-background-color: #191919; -fx-padding: 10; -fx-border-radius: 10; -fx-effect: dropshadow(three-pass-box, gray, 10, 0.5, 0, 0)");

        return tarjeta;
    }


}
