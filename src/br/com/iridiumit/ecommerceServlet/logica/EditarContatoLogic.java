package br.com.iridiumit.ecommerceServlet.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iridiumit.ecommerceServlet.DAOs.ContatoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Contato;

public class EditarContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));

        Contato contato = new Contato();
        
        ContatoDAO dao = new ContatoDAO();
        
        contato = dao.encontraContato(id);
                
        req.setAttribute("contato", contato);

        return "/WEB-INF/jsp/contato/contato.jsp";
	}

}
