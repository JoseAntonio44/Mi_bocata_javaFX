package org.example.mi_bocadillo_javafx.service;

import org.example.mi_bocadillo_javafx.dao.PedidoDAO;
import org.example.mi_bocadillo_javafx.model.Pedido;

import java.util.List;

public class PedidoService {
    public List<Pedido> obtenerPedidosPorAlumno(String email){
        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.PedirBocadillo(email);
    }
}
