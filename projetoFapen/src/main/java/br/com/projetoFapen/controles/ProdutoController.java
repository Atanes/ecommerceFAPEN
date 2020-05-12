package br.com.projetoFapen.controles;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.projetoFapen.infra.FileSaver;
import br.com.projetoFapen.modelos.Produto;
import br.com.projetoFapen.modelos.TipoPreco;
import br.com.projetoFapen.repositorios.ProdutoRepositorio;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepositorio produtos;
	
	@Autowired
	private FileSaver saver;

	@GetMapping
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("produto/listaprodutos");
		
		modelAndView.addObject("tipoPrecos", TipoPreco.values());

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
	public ModelAndView salvar(MultipartFile imagem, @Valid Produto produto, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(produto);
		}
		
		if(result.getFieldValue("promocao").equals("true")) {
			produto.setPromocao(true);
		}else {
			produto.setPromocao(false);
		}
		
		String path = saver.write("imagens_produtos", imagem);
	    produto.setUrl_imagem(path);

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
	
	@ModelAttribute("ListaTiposPrecos")
	public List<TipoPreco> ListaTiposPrecos() {
		return Arrays.asList(TipoPreco.values());
	}

}
