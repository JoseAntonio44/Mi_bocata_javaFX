package org.example.mi_bocadillo_javafx.dao;


import org.example.mi_bocadillo_javafx.model.Usuario;
import org.example.mi_bocadillo_javafx.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

    public Usuario obtenerPorEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Usuario WHERE email = :email", Usuario.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    public void guardarUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}