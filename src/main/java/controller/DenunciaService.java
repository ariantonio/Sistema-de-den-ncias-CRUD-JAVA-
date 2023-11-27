package controller;

import DAO.CidadaoDAO;
import DAO.DenunciaDAO;
import model.Cidadao;
import model.Denuncia;

public class DenunciaService {
    Denuncia denuncia = new Denuncia();

    public boolean registraDenuncia(Denuncia denuncia){
        DenunciaDAO denunciaDAO = new DenunciaDAO();
        return denunciaDAO.inserir(denuncia);
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }
}
