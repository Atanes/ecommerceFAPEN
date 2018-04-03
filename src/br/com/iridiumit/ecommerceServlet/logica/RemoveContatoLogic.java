package br.com.iridiumit.ecommerceServlet.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iridiumit.ecommerceServlet.DAOs.ContatoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Contato;

public class RemoveContatoLogic implements Logica {

    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        int id = Integer.parseInt(req.getParameter("id"));

        Contato contato = new Contato();
        contato.setId(id);

        ContatoDAO dao = new ContatoDAO();
        dao.remove(contato);

        System.out.println("Excluindo contato... ");

        return "mvc?logica=ListaContatosLogic";
    }
}
