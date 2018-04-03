package br.com.iridiumit.ecommerceServlet.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iridiumit.ecommerceServlet.DAOs.ContatoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Contato;

public class AdicionaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse res) throws Exception {
		 // buscando os parâmetros no request
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

        // salva o contato
        ContatoDAO dao = new ContatoDAO();
        dao.inserir(contato);
        
        System.out.println("Incluindo um novo Contato...");

        return "mvc?logica=ListaContatosLogic";
	}

}
