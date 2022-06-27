package br.com.projetoFapen.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoFapen.modelos.Grupo;

public interface GrupoRepositorio extends JpaRepository<Grupo, Long> {
	
}
