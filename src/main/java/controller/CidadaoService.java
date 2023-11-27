package controller;

import DAO.CidadaoDAO;
import model.Cidadao;

public class CidadaoService {
    Cidadao cidadao = new Cidadao();
    public boolean registraCidadao(Cidadao cidadao){
        CidadaoDAO cidadaoDAO = new CidadaoDAO();
        return cidadaoDAO.inserir(cidadao);
    }
    public boolean consultaCidadao(String nome, String senha){
        CidadaoDAO cidadaoDAO = new CidadaoDAO();
        this.cidadao = cidadaoDAO.pesquisar(nome, senha);
        if (this.cidadao!=null){
            return true;
        }else {
            return false;
        }
    }
        public boolean alteraCidadao(Cidadao cidadao){
        CidadaoDAO cidadaoDAO = new CidadaoDAO();
        return cidadaoDAO.alterar(cidadao);
    }

}
