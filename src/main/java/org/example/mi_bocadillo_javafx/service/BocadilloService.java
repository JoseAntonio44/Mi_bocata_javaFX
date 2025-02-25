package org.example.mi_bocadillo_javafx.service;


import org.example.mi_bocadillo_javafx.dao.BocadilloDAO;
import org.example.mi_bocadillo_javafx.model.Bocadillo;

import java.util.List;

public class BocadilloService {
    private final BocadilloDAO bocadilloDAO = new BocadilloDAO();
    private String mensaje = "NO DISPONIBLE";


    public String obtenerNombreBocataFrio(){
        if(bocadilloDAO.getBocadilloFrioHoy() != null){
            return bocadilloDAO.getBocadilloFrioHoy().getNombre();
        }else {
            return mensaje;
        }

    }
    public String obtenerNombreBocataCaliente(){
        if (bocadilloDAO.getBocadilloCalienteHoy()!= null){
            return bocadilloDAO.getBocadilloCalienteHoy().getNombre();

        }else {
            return mensaje;
        }
    }

    public List<Bocadillo> mostrarListaBocadillos(){
        return bocadilloDAO.getListaBocadillos();
    }


    public void actualizarBocadillo(Bocadillo bocadillo) {
        bocadilloDAO.actualizarBocadillo(bocadillo);
    }

    public Bocadillo obtenerBocadilloPorNombre(String nombre) {
        return bocadilloDAO.getBocadilloByNombre(nombre);
    }
}
