package org.example.mi_bocadillo_javafx.dao;


import org.example.mi_bocadillo_javafx.model.Usuario;
import org.example.mi_bocadillo_javafx.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsuarioDAO {

    public Usuario obtenerUsuarioPorEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = null;
        try {
            Query<Usuario> query = session.createQuery("FROM Usuario WHERE email = :email", Usuario.class);
            query.setParameter("email", email);
            usuario = query.uniqueResult();
        } finally {
            session.close();
        }
        return usuario;
    }
}