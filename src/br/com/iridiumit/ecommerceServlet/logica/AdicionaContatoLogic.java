package br.com.iridiumit.ecommerceServlet.logica;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iridiumit.ecommerceServlet.DAOs.ContatoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Contato;

public class AdicionaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse res) throws Exception {
		 // buscando os parametros no request
		
		int id = Integer.parseInt(request.getParameter("id"));
		ContatoDAO dao = new ContatoDAO();
			
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String assunto = request.getParameter("assunto");
        String mensagem = request.getParameter("mensagem");

        // monta um objeto contato
        Contato contato = new Contato();
        
        contato.setNome(nome);
        contato.setTelefone(telefone);
        contato.setEmail(email);
        contato.setAssunto(assunto);
        contato.setMensagem(mensagem);
        
		if (id != 0) {
			// Atualiza os dados do contato
			System.out.println("Salvando um novo Contato..." + contato.getNome());
			contato.setId(id);
			dao.altera(contato);
		} else {
			// salva o contato
			System.out.println("Incluindo um novo Contato..." + contato.getNome());
			dao.inserir(contato);
		}       
        
		return "mvc?logica=ListaContatosLogic";
	}

}
