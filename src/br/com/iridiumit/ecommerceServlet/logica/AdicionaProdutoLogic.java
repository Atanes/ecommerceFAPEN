package br.com.iridiumit.ecommerceServlet.logica;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.iridiumit.ecommerceServlet.DAOs.ProdutoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Produto;

public class AdicionaProdutoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse res) throws Exception {
		
		/*Identifica se o formulario é do tipo multipart/form-data*/
		if (ServletFileUpload.isMultipartContent(request)) {
				
				ProdutoDAO dao = new ProdutoDAO();
				
				Produto p = new Produto();
				// buscando os parametros no request
				int id = 0;
				
				try {
				/*Faz o parse do request*/
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				
				/*Escreve a o arquivo na pasta img*/
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						item.write(new File("C:/Temp/ImagensEcommerce" + File.separator));
						p.setUrl_imagem(item.getName());
					}else{
						if(item.getFieldName().equals("id")){  
							id = Integer.parseInt(item.getString()); 
			             }
						if(item.getFieldName().equals("descricao")){  
							p.setDescricao(item.getString()); 
			             }
						if(item.getFieldName().equals("preco_atual")){  
							p.setPreco_atual(new BigDecimal(item.getString())); 
			             }
						if(item.getFieldName().equals("preco_antigo")){  
							p.setPreco_antigo(new BigDecimal(item.getString())); 
			             }
					}
					System.out.println(item.getFieldName());
				}
				
				} catch (Exception ex) {
					System.out.println("Upload de arquivo falhou devido a "+ ex);
				}
				
				System.out.println(p.getUrl_imagem());
				
				if (id != 0) {
					// Atualiza os dados do contato
					System.out.println("Salvando um novo produto..." + p.getDescricao());
					p.setId(id);
					dao.altera(p);
				} else {
					// salva o contato
					System.out.println("Incluindo um novo Produto..." + p.getDescricao());
					dao.inserir(p);
				}       

		} else {
			System.out.println("Desculpe este Servlet lida apenas com pedido de upload de arquivos");
		}
		
		return "mvc?logica=ListaProdutosLogic";
	}
}
