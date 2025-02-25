package org.example.mi_bocadillo_javafx.dao;

import org.example.mi_bocadillo_javafx.model.Pedido;
import org.example.mi_bocadillo_javafx.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class PedidoDAO {


    //Metodo para obtener todos los pedidos de un alumno
    public List<Pedido> getPedidosByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Pedido> query = session.createQuery(
                            "FROM Pedido WHERE alumno.usuario.email = :email", Pedido.class)
                    .setParameter("email", email);

            return query.getResultList();
        }
    }
    //Metodo para obtener los pedidos de hoy del alumno
    public List<Pedido> getPedidosHoyAlumno(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Pedido> query = session.createQuery(
                            "FROM Pedido WHERE DATE(fecha) = DATE(NOW()) AND alumno.usuario.email = :email", Pedido.class)
                    .setParameter("email", email);
            return query.getResultList();
        }
    }
    public List<Pedido> getPedidosHoy() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Pedido> query = session.createQuery(
                            "FROM Pedido WHERE DATE(fecha) = DATE(NOW())", Pedido.class);
            return query.getResultList();
        }
    }

    //Metodo para guardar un nuevo pedido
    public boolean pushNuevoPedido(Pedido pedido) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(pedido);
            transaction.commit();
            System.out.println("Pedido guardado exitosamente");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("Error al guardar el pedido: " + e.getMessage());
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarFechaRecogido(Pedido pedido) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Pedido pedidoActualizado = session.createQuery(
                            "FROM Pedido WHERE alumno = :alumno AND bocadillo = :bocadillo AND fecha = :fecha", Pedido.class)
                    .setParameter("alumno", pedido.getAlumno())
                    .setParameter("bocadillo", pedido.getBocadillo())
                    .setParameter("fecha", pedido.getFecha())
                    .uniqueResult();

            if (pedidoActualizado != null) {
                pedidoActualizado.setF_recogido(new Date());
                session.update(pedidoActualizado);
                transaction.commit();
                System.out.println("Fecha de recogido actualizada exitosamente");
                return true;
            } else {
                System.out.println("Pedido no encontrado en la base de datos.");
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al actualizar la fecha de recogido: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


}
