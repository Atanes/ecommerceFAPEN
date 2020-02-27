package br.com.projetoFapen.controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {
	
	@GetMapping("/produto/novo")
	public String incluirProduto() {
		return "produto/cadprodutos";
	}

}
