package br.com.iridiumit.ecommerceServlet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iridiumit.ecommerceServlet.DAOs.ContatoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Contato;

/**
 * Servlet implementation class EditarContatoServlet
 */
@WebServlet("/editarContato")
public class EditarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarContatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		
		ContatoDAO dao = new ContatoDAO();

        Contato contato = dao.encontraContato(id);
        
        req.setAttribute("contato", contato);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/contato.jsp");
        rd.forward(req,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
