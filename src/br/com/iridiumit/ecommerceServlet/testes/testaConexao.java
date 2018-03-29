package br.com.iridiumit.ecommerceServlet.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.iridiumit.ecommerceServlet.conexao.ConnectionFactory;

public class testaConexao {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = new ConnectionFactory().getConnection();
		System.out.println("Conexão OK!!");
		conn.close();
	}
}
