package br.com.iridiumit.ecommerceServlet.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iridiumit.ecommerceServlet.modelos.Contato;

public class EditarContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));

        Contato contato = new Contato();
        contato.setId(id);

        contato.setNome(req.getParameter("nome"));
        contato.setTelefone(req.getParameter("telefone"));
        contato.setEmail(req.getParameter("email"));
        contato.setAssunto(req.getParameter("assunto"));
        contato.setMensagem(req.getParameter("mensagem"));
        
        req.setAttribute("contato", contato);

        return "/WEB-INF/jsp/contato.jsp";
	}

}
