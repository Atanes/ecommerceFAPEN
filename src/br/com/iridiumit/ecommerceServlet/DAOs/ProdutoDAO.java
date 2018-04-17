package br.com.iridiumit.ecommerceServlet.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.iridiumit.ecommerceServlet.conexao.ConnectionFactory;
import br.com.iridiumit.ecommerceServlet.modelos.Produto;


public class ProdutoDAO {

	Connection conn;

	public ProdutoDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}

	public void inserir(Produto produto) {
		String sql = "insert into produtos " + "(descricao,imagem,preco_atual,preco_antigo)" + " values (?,?,?,?)";

		try {
			// prepared statement para inclusão dos dados na base de dados
			PreparedStatement stmt = conn.prepareStatement(sql);

			// seta os valores

			stmt.setString(1, produto.getDescricao());
			stmt.setString(2, produto.getUrl_imagem());
			stmt.setBigDecimal(3, produto.getPreco_atual());
			stmt.setBigDecimal(4, produto.getPreco_antigo());
			

			// executa o comando e faz a inclusão dos dados no banco de dados
			stmt.execute();
			//Fecha a conex�o com o Banco de dados para evitar estouro de mem�ria
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> listar() {
        try {
            List<Produto> produtos = new ArrayList<Produto>();
            /* Para PostgreSQL
             * PreparedStatement stmt = this.conn.
                    prepareStatement("select id, descricao, imagem, preco_atual::numeric, preco_antigo::numeric from produtos");*/
            PreparedStatement stmt = this.conn.
                    prepareStatement("select id, descricao, imagem, preco_atual, preco_antigo from produtos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Produto
            	Produto produto = new Produto();
            	produto.setId(rs.getInt("id"));
            	produto.setDescricao(rs.getString("descricao"));
            	produto.setUrl_imagem(rs.getString("imagem"));
            	
            	produto.setPreco_atual(rs.getBigDecimal("preco_atual"));
   
            	produto.setPreco_antigo(rs.getBigDecimal("preco_antigo"));

                // adicionando o objeto lista
                produtos.add(produto);
            }
            rs.close();
            stmt.close();
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void altera(Produto produto) {
	    String sql = "update produtos set descricao=?, imagem=?, preco_atual=?," +
	            "preco_antigo=? where id=?";
	    try {
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, produto.getDescricao());
			stmt.setString(2, produto.getUrl_imagem());
			stmt.setBigDecimal(3, produto.getPreco_atual());
			stmt.setBigDecimal(4, produto.getPreco_antigo());
	        stmt.setLong(5, produto.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void remove(Produto produto) {
	    try {
	        PreparedStatement stmt = conn.prepareStatement("delete " +
	                "from produtos where id=?");
	        stmt.setLong(1, produto.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public Produto encontraProduto(int id) {
	    try {
	    	/* Para PostgreSQL
	    	 * PreparedStatement stmt = this.conn.
                    prepareStatement("select id, descricao, imagem, preco_atual::numeric, preco_antigo::numeric from produtos where id=?");*/
	    	PreparedStatement stmt = this.conn.
                    prepareStatement("select id, descricao, imagem, preco_atual, preco_antigo from produtos where id=?");
	    	stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Produto produto = new Produto();
	        if(rs.next()) {
	        	produto.setId(rs.getInt("id"));
            	produto.setDescricao(rs.getString("descricao"));
            	produto.setUrl_imagem(rs.getString("imagem"));
            	
            	produto.setPreco_atual(rs.getBigDecimal("preco_atual"));
            	produto.setPreco_antigo(rs.getBigDecimal("preco_antigo"));
	        }
	        rs.close();
            stmt.close();
            return produto;
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
}