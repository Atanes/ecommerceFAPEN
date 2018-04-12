package br.com.iridiumit.ecommerceServlet.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iridiumit.ecommerceServlet.DAOs.ProdutoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Produto;

public class EditarProdutoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));

        ProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = dao.encontraProduto(id);
        
        req.setAttribute("produto", produto);

        return "/WEB-INF/jsp/produto/produto.jsp";
	}

}
