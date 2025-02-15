package org.example.mi_bocadillo_javafx.dao;

import org.example.mi_bocadillo_javafx.model.Pedido;
import org.example.mi_bocadillo_javafx.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PedidoDAO {

    public List<Pedido> PedirBocadillo(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Pedido> query = session.createQuery(
                            "FROM Pedido WHERE alumno.usuario.email = :email", Pedido.class)
                    .setParameter("email", email);

            return query.getResultList(); // Retornamos la lista en lugar de imprimirla
        }
    }
}
