package br.com.projetoFapen.controles;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.projetoFapen.modelos.Produto;
import br.com.projetoFapen.repositorios.ProdutoRepositorio;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepositorio produtos;

	@GetMapping
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("produto/listaprodutos");

		modelAndView.addObject("produtos", produtos.findAll());

		return modelAndView;
	}

	@GetMapping("/novo")
	public ModelAndView novo(Produto produto) {

		ModelAndView modelAndView = new ModelAndView("produto/cadprodutos");

		modelAndView.addObject(produto);

		return modelAndView;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(produto);
		}

		produtos.save(produto);

		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!!");

		return new ModelAndView("redirect:/produto");

	}

	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {

		return novo(produtos.getOne(id));
	}

	@PostMapping(value = "excluir/{id}")
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {

		produtos.deleteById(id);

		attributes.addFlashAttribute("mensagem", "Produto excluido com sucesso!!");

		return "redirect:/produto";
	}

}
