package DAO;

import model.Cidadao;
import model.FuncionarioGoverno;

import java.util.List;

public class FuncionarioGovernoDAO extends UsuarioDAO {

    public FuncionarioGovernoDAO() {
        super.setConnection(Conexao.getconection());
    }

    public List<FuncionarioGoverno> listar() {
        return null;
    }

    @Override
    public boolean inserir() {
        return super.inserir();
    }

    @Override
    public boolean alterar() {
        return super.alterar();
    }

    @Override
    public boolean remover() {
        return super.remover();
    }
}
