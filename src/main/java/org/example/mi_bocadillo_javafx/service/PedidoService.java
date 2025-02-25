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
    public List<Pedido> obtenerPedidosHoy(){
        return pedidoDAO.getPedidosHoy();
    }

    public String guardarPedido(boolean esFrio) {
        Usuario usuario = AuthManager.getInstance().getUsuarioActual();

        //Verifica si el usuario tiene algún alumno asignado
        if (usuario.getAlumnos().isEmpty()) {
            return "El usuario no está asignado a ningun alumno.";
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
            return "No hay bocadillo disponible para hoy.";
        }

        //Verifica si ya hay un pedido hoy
        List<Pedido> pedidosHoy = pedidoDAO.getPedidosHoyAlumno(usuario.getEmail());
        if (!pedidosHoy.isEmpty()) {
            return "Ya hay un pedido realizado hoy.";
        }

        //Crea un nuevo objeto de pedido
        Pedido pedido = new Pedido();
        pedido.setFecha(new Date());
        pedido.setAlumno(usuario.getAlumnos().get(0));
        pedido.setBocadillo(bocadillo);
        pedido.setPvp(bocadillo.getPvp());

        PedidoDAO pedidoDAO = new PedidoDAO();
        boolean exito = pedidoDAO.pushNuevoPedido(pedido);

        //Retorna un mensaje de éxito o error
        if (exito) {
            return "Pedido realizado con éxito.";
        } else {
            return "Hubo un error al realizar el pedido.";
        }
    }

    public void marcarRecogido(Pedido pedido) {
        //Recibir del controlador un objeto pedido
        if (pedido.getF_recogido() == null) {
            boolean actualizado = pedidoDAO.actualizarFechaRecogido(pedido);
            if (actualizado) {
                System.out.println("Pedido marcado como recogido.");
            } else {
                System.out.println("No se pudo marcar el pedido como recogido.");
            }
        } else {
            System.out.println("Este pedido ya ha sido recogido.");
        }
    }

}
