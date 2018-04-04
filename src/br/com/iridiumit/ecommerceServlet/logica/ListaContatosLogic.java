package br.com.iridiumit.ecommerceServlet.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iridiumit.ecommerceServlet.DAOs.ContatoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Contato;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Contato> contatos = new ContatoDAO().listar();

        req.setAttribute("contatos", contatos);

        return "/WEB-INF/jsp/listaContatos.jsp";
	}

}