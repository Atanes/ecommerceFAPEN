package br.com.iridiumit.ecommerceServlet.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.iridiumit.ecommerceServlet.conexao.ConnectionFactory;
import br.com.iridiumit.ecommerceServlet.modelos.Contato;


public class ContatoDAO {

	Connection conn;

	public ContatoDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}

	public void inserir(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,telefone,assunto,mensagem)" + " values (?,?,?,?,?)";

		try {
			// prepared statement para inclusão dos dados na base de dados
			PreparedStatement stmt = conn.prepareStatement(sql);

			// seta os valores

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getTelefone());
			stmt.setString(4, contato.getAssunto());
			stmt.setString(5, contato.getMensagem());
			
			/* Para adicionar uma data ou outros tipos de dados por exemplo
			 * stmt.setDate(4, new Date(
	        contato.getDataNascimento().getTimeInMillis()));
			
			stmt.setInt(parameterIndex, x);
			stmt.setLong(parameterIndex, x);*/
			

			// executa o comando e faz a inclusão dos dados no banco de dados
			stmt.execute();
			//Fecha a conexão com o Banco de dados para evitar estouro de memória
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getContatos() {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.conn.
                    prepareStatement("select * from contatos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setAssunto(rs.getString("assunto"));
                contato.setMensagem(rs.getString("mensagem"));

                /* Para trabalhar com datas é preciso fazer um CAST do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);*/

                // adicionando o objeto à lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void altera(Contato contato) {
	    String sql = "update contatos set nome=?, email=?, telefone=?," +
	            "assunto=?, mensagem=? where id=?";
	    try {
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getTelefone());
			stmt.setString(4, contato.getAssunto());
			stmt.setString(5, contato.getMensagem());
	        stmt.setLong(6, contato.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void remove(Contato contato) {
	    try {
	        PreparedStatement stmt = conn.prepareStatement("delete " +
	                "from contatos where id=?");
	        stmt.setLong(1, contato.getId());
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
}