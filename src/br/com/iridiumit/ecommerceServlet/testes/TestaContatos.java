package br.com.iridiumit.ecommerceServlet.testes;

import java.util.List;

import br.com.iridiumit.ecommerceServlet.DAOs.ContatoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Contato;

public class TestaContatos {

	public static void main(String[] args) {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		List<Contato> contatos = contatoDAO.listar();
		
		
		for( Contato contato : contatos) {
			System.out.println("ID: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
		}

	}

}
