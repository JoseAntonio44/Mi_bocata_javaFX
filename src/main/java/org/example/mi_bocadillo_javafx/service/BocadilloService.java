package org.example.mi_bocadillo_javafx.service;


import org.example.mi_bocadillo_javafx.dao.BocadilloDAO;
import org.example.mi_bocadillo_javafx.model.Bocadillo;

public class BocadilloService {
    private final BocadilloDAO bocadilloDAO = new BocadilloDAO();

    public Bocadillo obtenerBocataFrio(){
        return bocadilloDAO.getBocadilloFrioHoy();
    }
    public Bocadillo obtenerBocataCaliente(){
        return bocadilloDAO.getBocadilloCalienteHoy();
    }

}
