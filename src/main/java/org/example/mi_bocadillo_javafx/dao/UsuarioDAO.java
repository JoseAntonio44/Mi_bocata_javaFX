package org.example.mi_bocadillo_javafx.dao;


import jakarta.persistence.NoResultException;
import org.example.mi_bocadillo_javafx.model.Usuario;
import org.example.mi_bocadillo_javafx.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UsuarioDAO {

    public Usuario getUsuarioByEmail(String email, String password) {
        Usuario usuario = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery(
                    "FROM Usuario WHERE email = :email AND password = :password", Usuario.class)
                    .setParameter("email", email)
                    .setParameter("password", password);

            usuario = query.uniqueResult(); // Devuelve un único resultado o null si no hay coincidencias
        } catch (NoResultException e) {
            System.out.println("Usuario no encontrado: " + email);
        } catch (Exception e) {
            System.out.println("Error al obtener usuario: " + e.getMessage());
        }
        return usuario;
    }

}