package controller;

import DAO.CidadaoDAO;
import model.Cidadao;

public class RegistraCidadao {
    public boolean registraCidadao(Cidadao cidadao){
        CidadaoDAO cidadaoDAO = new CidadaoDAO();
        return cidadaoDAO.inserir(cidadao);
    }
}
