package DAO;

import model.Cidadao;
import model.Denuncia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadaoDAO extends UsuarioDAO {

    public CidadaoDAO() {
        super.setConnection(Conexao.getconection());
    }

    public List<Cidadao> listar() {
        String sql = "SELECT * FROM Tbl_Cidadao";
        List<Cidadao> cidadaoDb = new ArrayList<>();
        try {
            PreparedStatement stmt = super.getConnection().prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Cidadao cidadao = new Cidadao();
                cidadao.setId(resultSet.getInt("id_Cidadao"));
                cidadao.setData_nascimento(String.valueOf(resultSet.getDate("dt_nascimento")));
                cidadao.setNome(resultSet.getString("nome"));
                cidadao.setSenha(resultSet.getString("senha"));
                cidadao.setEmail(resultSet.getString("email"));
                cidadaoDb.add(cidadao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cidadaoDb;
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
