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

import br.com.projetoFapen.modelos.Usuario;
import br.com.projetoFapen.repositorios.UsuarioRepositorio;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepositorio usuarios;

	@GetMapping
	public ModelAndView listar() {

		ModelAndView modelAndView = new ModelAndView("usuario/listausuarios");

		modelAndView.addObject("usuarios", usuarios.findAll());

		return modelAndView;
	}

	@GetMapping("/novo")
	public ModelAndView novo(Usuario usuario) {

		ModelAndView modelAndView = new ModelAndView("usuario/cadusuarios");

		modelAndView.addObject(usuario);

		return modelAndView;
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(usuario);
		}

		usuarios.save(usuario);

		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!!");

		return new ModelAndView("redirect:/usuario");

	}

	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {

		return novo(usuarios.getOne(id));
	}

	@PostMapping(value = "excluir/{id}")
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {

		usuarios.deleteById(id);

		attributes.addFlashAttribute("mensagem", "Usuario excluido com sucesso!!");

		return "redirect:/usuario";
	}

}
