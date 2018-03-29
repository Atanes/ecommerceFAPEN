package br.com.iridiumit.ecommerceServlet.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ecommerceFAPEN_BD", "UAtanes", "PAtanes");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
