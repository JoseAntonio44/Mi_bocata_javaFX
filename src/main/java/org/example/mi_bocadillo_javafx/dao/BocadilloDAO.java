package org.example.mi_bocadillo_javafx.dao;

import org.example.mi_bocadillo_javafx.model.Bocadillo;
import org.example.mi_bocadillo_javafx.util.HibernateUtil;
import org.hibernate.Session;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class BocadilloDAO {


    public Bocadillo getBocadilloFrioHoy() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Bocadillo.DiaSemana diaHoy = obtenerDiaHoy(); // Devuelve el enum DiaSemana
            return session.createQuery("FROM Bocadillo WHERE dia = :dia AND frio = 'Frio'", Bocadillo.class)
                    .setParameter("dia", diaHoy) // Pasa el enum
                    .setMaxResults(1)
                    .uniqueResult();
        }
    }

    public Bocadillo getBocadilloCalienteHoy() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Bocadillo.DiaSemana diaHoy = obtenerDiaHoy(); // Devuelve el enum DiaSemana
            return session.createQuery("FROM Bocadillo WHERE dia = :dia AND frio = 'Caliente'", Bocadillo.class)
                    .setParameter("dia", diaHoy) // Pasa el enum
                    .setMaxResults(1)
                    .uniqueResult();
        }
    }

    private Bocadillo.DiaSemana obtenerDiaHoy() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY: return Bocadillo.DiaSemana.Lunes;
            case TUESDAY: return Bocadillo.DiaSemana.Martes;
            case WEDNESDAY: return Bocadillo.DiaSemana.Miercoles;
            case THURSDAY: return Bocadillo.DiaSemana.Jueves;
            case FRIDAY: return Bocadillo.DiaSemana.Viernes;
            default: return null; // No se asignan bocadillos los fines de semana
        }
    }
}
