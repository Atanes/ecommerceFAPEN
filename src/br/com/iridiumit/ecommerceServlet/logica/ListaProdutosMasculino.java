package br.com.iridiumit.ecommerceServlet.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iridiumit.ecommerceServlet.DAOs.ProdutoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Produto;

public class ListaProdutosMasculino implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Produto> produtos = new ProdutoDAO().listar("masculino");

        req.setAttribute("produtos", produtos);

        return "/WEB-INF/jsp/masculino.jsp";
	}

}
