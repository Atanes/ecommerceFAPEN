package br.com.iridiumit.ecommerceServlet.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iridiumit.ecommerceServlet.DAOs.ProdutoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Produto;

public class RemoveProdutoLogic implements Logica {

    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        int id = Integer.parseInt(req.getParameter("id"));

        Produto produto = new Produto();
        produto.setId(id);

        ProdutoDAO dao = new ProdutoDAO();
        dao.remove(produto);

        System.out.println("Excluindo produto... ");

        return "mvc?logica=ListaProdutosLogic";
    }
}
