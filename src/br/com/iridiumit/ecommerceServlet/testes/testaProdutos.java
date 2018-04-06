package br.com.iridiumit.ecommerceServlet.testes;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import br.com.iridiumit.ecommerceServlet.DAOs.ProdutoDAO;
import br.com.iridiumit.ecommerceServlet.modelos.Produto;

public class testaProdutos {

	public static void main(String[] args) {
		
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto p = new Produto();
		
		p.setId(6);
		p.setDescricao("Camisa do Brasil");
		p.setUrl_imagem("imagensProdutos/imagemBrasil.jpg");
		p.setPreco_atual(new BigDecimal(50.55));
		p.setPreco_antigo(new BigDecimal(65.50));
		
		dao.altera(p);

		p.setId(7);
		p.setDescricao("Camisa da Magali");
		p.setUrl_imagem("imagensProdutos/imagemMagali.jpg");
		p.setPreco_atual(new BigDecimal(39.80));
		p.setPreco_antigo(null);
		
		dao.altera(p);
		
		List<Produto> produtos = dao.listar();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		for(Produto produto : produtos){
			System.out.print(produto.getId() + " - " + produto.getDescricao() + ", " 
					+ nf.format(produto.getPreco_atual()));
			
			if(produto.getPreco_antigo() != null){
				System.out.println(", " + nf.format(produto.getPreco_antigo()));			
			}else{
				System.out.println(", ------");
			}
		}
		
		System.out.println(dao.encontraProduto(6));
		System.out.println(dao.encontraProduto(7));

	}

}
