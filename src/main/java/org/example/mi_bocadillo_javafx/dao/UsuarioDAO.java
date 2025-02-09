package org.example.mi_bocadillo_javafx.dao;

import org.example.mi_bocadillo_javafx.model.Usuario;
import org.example.mi_bocadillo_javafx.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class UsuarioDAO {

    public Usuario validarCredenciales(String email, String password) {
        Usuario usuario = null;
        Transaction transaction = null;

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();


            Query<Usuario> query = session.createQuery(
                    "FROM Usuario WHERE email = :email AND password = :password", Usuario.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            usuario = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return usuario;
    }
}

