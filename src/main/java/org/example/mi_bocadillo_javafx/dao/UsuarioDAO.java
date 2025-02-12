package org.example.mi_bocadillo_javafx.dao;


import org.example.mi_bocadillo_javafx.model.Usuario;
import org.example.mi_bocadillo_javafx.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

    public Usuario getAlumnoByEmail(String email, String contraseña) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            /*return session.createQuery("FROM Usuario WHERE email = :email AND password = :password", Usuario.class)
                    .setParameter("email", email)
                    .setParameter("password", contraseña)
                    .getSingleResult();

             */
            return null;
        }
    }

}