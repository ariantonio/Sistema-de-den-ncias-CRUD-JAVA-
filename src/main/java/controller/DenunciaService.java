package controller;

import DAO.DenunciaDAO;
import java.util.List;
import model.Denuncia;

public class DenunciaService {
    Denuncia denuncia;

    public boolean registraDenuncia(Denuncia denuncia) {
        DenunciaDAO denunciaDAO = new DenunciaDAO();
        //System.out.println(denuncia.toString());
        return denunciaDAO.inserir(denuncia);
    }

    public boolean apagarDenuncia(int id) {
        DenunciaDAO denunciaDAO = new DenunciaDAO();
        return denunciaDAO.remover(id);
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public List<Denuncia> listarDenuncia() {
        DenunciaDAO denunciaDAO = new DenunciaDAO();
        return denunciaDAO.listar();
    }    
}   
