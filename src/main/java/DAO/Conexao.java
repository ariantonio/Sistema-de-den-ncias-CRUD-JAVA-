package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/a3_psc";
    private static final String username = "root";
    private static final String password = "";

    private static Connection conn;

    public static Connection getconection() {
        try {

            if (conn == null) {
                //Class.forName("src.driver");
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Conexão estabelecida com sucesso!");
                return conn;
            }else {
                System.out.println("Conexão estabelecida com sucesso!");
                return conn;
            }

        }catch (SQLException e){
            System.out.println("Erro de conexão com o banco de dados: " + e.getMessage());
            return null;
        }
    }
}
