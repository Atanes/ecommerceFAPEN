package br.com.iridiumit.ecommerceServlet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NavegacaoMenu
 */
@WebServlet(description = "Controle de navegação das páginas padrão no cabeçalho", urlPatterns = { "/navegacao" })
public class NavegacaoMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavegacaoMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException {

        String pagina = request.getParameter("pagina");

        try {
                request.getRequestDispatcher(pagina)
                        .forward(request,response);

        } catch (Exception e) {
            throw new ServletException(
                "A navegação causou uma exceção", e);
        }
    }
	
	

}
