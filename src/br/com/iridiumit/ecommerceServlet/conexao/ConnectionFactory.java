package br.com.iridiumit.ecommerceServlet.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
        try {
        	/* Para conexão com postgresql
        	 * Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ecommerceFAPEN_BD", "UAtanes", "PAtanes");*/
        	
        	// Para conexão com o MySql
        	Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ecommerceFAPEN_BD?useTimezone=true&serverTimezone=UTC", "UAtanes", "PAtanes");
        	
            // Não esquecer de colocar as classes de conexão do Mysql ou do PostgreSQL na pasta LIB
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
        	throw new RuntimeException(e);
		}
    }
}
