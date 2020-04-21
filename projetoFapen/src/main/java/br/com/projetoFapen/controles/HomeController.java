package br.com.projetoFapen.controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@GetMapping("/inicio")
	public String inicio() {
		return "inicio";
	}
	
	/*
	 * @PostMapping("/logout") public String fim() { return "fim"; }
	 */

}
