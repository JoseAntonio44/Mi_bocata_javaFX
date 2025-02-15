package org.example.mi_bocadillo_javafx.service;

import org.example.mi_bocadillo_javafx.auth.AuthManager;
import org.example.mi_bocadillo_javafx.dao.BocadilloDAO;
import org.example.mi_bocadillo_javafx.dao.PedidoDAO;
import org.example.mi_bocadillo_javafx.model.Bocadillo;
import org.example.mi_bocadillo_javafx.model.Pedido;
import org.example.mi_bocadillo_javafx.model.Usuario;

import java.util.Date;
import java.util.List;

public class PedidoService {
    BocadilloDAO bocadilloDAO = new BocadilloDAO();
    PedidoDAO pedidoDAO = new PedidoDAO();


    public List<Pedido> obtenerPedidosPorAlumno(String email){
        return pedidoDAO.getPedidosByEmail(email);
    }

    public boolean guardarPedido(boolean esFrio) {
        Usuario usuario = AuthManager.getInstance().getUsuarioActual();

        //Verifica si el usuario tiene algún alumno asignado
        if (usuario.getAlumnos().isEmpty()) {
            System.out.println("El usuario no está asignado a ningun alumno.");
            return false;
        }

        //Bocadillo (frío o caliente)
        Bocadillo bocadillo = null;
        if (esFrio) {
            bocadillo = bocadilloDAO.getBocadilloFrioHoy();
        } else {
            bocadillo = bocadilloDAO.getBocadilloCalienteHoy();
        }

        //Verifica si el bocadillo es válido
        if (bocadillo == null) {
            System.out.println("No hay bocadillo disponible para hoy.");
            return false;
        }


        //Crea un nuevo objeto de pedido
        Pedido pedido = new Pedido();
        pedido.setFecha(new Date());
        pedido.setAlumno(usuario.getAlumnos().get(0));
        pedido.setBocadillo(bocadillo);
        pedido.setPvp(bocadillo.getPvp());



        PedidoDAO pedidoDAO = new PedidoDAO();
        return pedidoDAO.pushNuevoPedido(pedido);
    }
}
