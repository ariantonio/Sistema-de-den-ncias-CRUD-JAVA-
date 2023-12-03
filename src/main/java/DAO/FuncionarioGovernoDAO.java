package DAO;

import model.Cidadao;
import model.FuncionarioGoverno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.List;

public class FuncionarioGovernoDAO extends UsuarioDAO {

    public FuncionarioGovernoDAO() {
        super.setConnection(Conexao.getconection());
    }

    public List<FuncionarioGoverno> listar(){
       String sql = "SELECT * FROM Tbl_Fun_Gov";
       List<FuncionarioGoverno> funcionarioDb = new ArrayList<>();
       try{
          PreparedStatement stmt = super.getConnection().prepareStatement(sql);
          ResultSet resultSet = stmt.executeQuery();
          while (resultSet.next()){
              FuncionarioGoverno func = new FuncionarioGoverno();
              func.setId(resultSet.getInt("id_Fun_Gov"));
              func.setNome(resultSet.getString("nome"));
              func.setSenha(resultSet.getString("senha"));
              funcionarioDb.add(func);
            }
          }catch(SQLException e){
                throw new RuntimeException(e);
            }
            return funcionarioDb;
       }
    public FuncionarioGoverno pesquisar(String nome, String senha){
        String sql = "SELECT * FROM Tbl_Fun_Gov WHERE nome = ? AND senha = ?";
        FuncionarioGoverno funcionarioDb = new FuncionarioGoverno();
        boolean encontrou = false;
        try{
            PreparedStatement stmt = super.getConnection().prepareStatement(sql);
            stmt.setString(1,nome);
            stmt.setString(2,senha);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                encontrou = true;
                FuncionarioGoverno funcionario = new FuncionarioGoverno();
                funcionario.setId(resultSet.getInt("id_Fun_Gov"));
                funcionario.setNome(resultSet.getString("nome"));                
                funcionario.setSenha(resultSet.getString("senha"));
                System.out.println("Bem vindo, funcionário!");
            }else{
                System.out.println("Erro ao encontrar funcionário");
            }
        }catch(SQLException e){
            System.out.println("Erro ao consultar no banco de dados");
            throw new RuntimeException(e);
        }
        return encontrou ? funcionarioDb: null;
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
    public boolean remover(int id) {
        return super.remover(id);
    }
}
