package DAO;

import model.Cidadao;
import model.Denuncia;
import org.jetbrains.annotations.NotNull;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DenunciaDAO {
    private Connection connection;

    public DenunciaDAO() {
        this.connection=Conexao.getconection();
    }
    public List<Denuncia> listar(){
        String sql = "SELECT * FROM Tbl_Denuncia";
        List<Denuncia> denunciasDb = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Denuncia denuncia = new Denuncia();
                denuncia.setId(resultSet.getInt("id_Denuncia"));
                // Mapeando a lista de fotos
                /*
                List<String> fotos = new ArrayList<>();
                // Supondo que as fotos estejam armazenadas em coluna chamada "foto" e separadas por vírgula
                String fotosString = resultSet.getString("foto");
                if (fotosString != null && !fotosString.isEmpty()) {
                    String[] fotosArray = fotosString.split(",");
                    for (String foto : fotosArray) {
                        fotos.add(foto.trim());
                    }
                }
                denuncia.setFoto(fotos);
                denuncia.setTipoDeProblema(resultSet.getString("tipoDeProblema"));
                */

                denuncia.setDescricao(resultSet.getString("descrição"));
                denuncia.setLocalizacao(resultSet.getString("localizacao"));
 //               denuncia.setRua(resultSet.getString("rua"));
 //               denuncia.setComp(resultSet.getString("complemento"));
 //               denuncia.setStatus(resultSet.getString("status"));
                denunciasDb.add(denuncia);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return denunciasDb;
    }

   /* public List<Cidadao> listarById() {
        String sql = "SELECT * FROM Tbl_Cidadao ";
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
    }*/

    public boolean inserir(@NotNull Denuncia denuncia){
        String sql = "INSERT INTO Tbl_Denuncia(descrição, status_atualizacao, localizacao, imagem_anexada) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, denuncia.getDescricao());
            stmt.setString(2, denuncia.getStatus());
            stmt.setString(3, denuncia.getLocalizacao());
            stmt.setString(4, null);
            stmt.execute();
            System.out.println("cadastro da denuncia bem sucedida");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean alterar(Denuncia denuncia){
        return false;
    }
    public boolean remover(int id) {
        String sql = "DELETE FROM Tbl_Denuncia WHERE id_Denuncia=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("denuncia apagada!");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
