package DAO;

import model.Denuncia;

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
                denuncia.setId(resultSet.getInt("id"));
                // Mapeando a lista de fotos
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
                denuncia.setDescricao(resultSet.getString("descricao"));
                denuncia.setLocalizacao(resultSet.getString("localizacao"));
                denuncia.setStatus(resultSet.getString("status"));
                denunciasDb.add(denuncia);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return denunciasDb;
    }
    public boolean inserir(Denuncia denuncia){
        return false;
    }
    public boolean alterar(Denuncia denuncia){
        return false;
    }
    public boolean remover(int id){
        return false;
    }
}
