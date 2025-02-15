package org.example.mi_bocadillo_javafx.dao;

import org.example.mi_bocadillo_javafx.auth.AuthManager;
import org.example.mi_bocadillo_javafx.model.Bocadillo;
import org.example.mi_bocadillo_javafx.model.Pedido;
import org.example.mi_bocadillo_javafx.model.Usuario;
import org.example.mi_bocadillo_javafx.service.BocadilloService;
import org.example.mi_bocadillo_javafx.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class PedidoDAO {


    public List<Pedido> getPedidosByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Pedido> query = session.createQuery(
                            "FROM Pedido WHERE alumno.usuario.email = :email", Pedido.class)
                    .setParameter("email", email);

            return query.getResultList();
        }
    }

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
}
