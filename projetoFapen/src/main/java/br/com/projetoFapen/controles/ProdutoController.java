package br.com.projetoFapen.controles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.projetoFapen.infra.FotoService;
import br.com.projetoFapen.modelos.Preco;
import br.com.projetoFapen.modelos.Produto;
import br.com.projetoFapen.modelos.TipoPreco;
import br.com.projetoFapen.repositorios.ProdutoRepositorio;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepositorio produtos;
	
	@Autowired
	private FotoService fotoService;

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
		
		List<Preco> precos = new ArrayList<Preco>();
		List<TipoPreco> tipos = new LinkedList<>(Arrays.asList(TipoPreco.values()));
		
		System.out.println(produto.getId());
		
		if(produto.getPrecos() != null){
			for(Preco preco : produto.getPrecos()) {
				precos.add(preco);
				System.out.println(preco.valorMoeda());
				if(tipos.contains(preco.getTipo())) {
					tipos.removeIf(tipo -> tipo.name() == preco.getTipo().name());
				}
				
			}
		}
		
		for(TipoPreco tipo : tipos) {
			precos.add(new Preco(tipo));
		}
		
		Collections.sort(precos);
		
		System.out.println(precos.get(0).getValor());

		modelAndView.addObject("precos",  precos);
		modelAndView.addObject(produto);

		return modelAndView;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(@RequestParam("file") MultipartFile file, @Valid Produto produto, BindingResult result, RedirectAttributes attributes) {

		produto.getPrecos().removeIf(preco -> preco.getValor() == null);
		
		if (produto.getPrecos().isEmpty()) {
			result.rejectValue("precos", "precos.not.null");
		}
		
		if(result.getFieldValue("promocao").equals("true")) {
			produto.setPromocao(true);
		}else {
			produto.setPromocao(false);
		}
		
		if (result.hasErrors()) {
			return novo(produto);
		}
		
		if (!file.isEmpty()) {
			
			if(produto.getUrl_imagem() != null && !produto.getUrl_imagem().isEmpty()) {
				fotoService.removerFoto(produto.getUrl_imagem());
			}
			
			String arquivoFoto = fotoService.doUpload(file, produto);

			if (arquivoFoto.equals("erro")) {
				attributes.addFlashAttribute("mensagem", "Problemas para salvar a imagem do produto!!");
				return novo(produto);
			} else {
				produto.setUrl_imagem(arquivoFoto);
			}
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
	
	@ModelAttribute("ListaTiposPrecos")
	public List<TipoPreco> ListaTiposPrecos() {
		return Arrays.asList(TipoPreco.values());
	}
	
	@GetMapping("/imagem/{nome:.*}")
	public @ResponseBody byte[] recuperarFoto(@PathVariable String nome) throws IOException {
		
		return fotoService.recuperarFoto(nome);
	}

}
