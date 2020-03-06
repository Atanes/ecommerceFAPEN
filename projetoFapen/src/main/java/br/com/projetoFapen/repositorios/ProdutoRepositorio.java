package br.com.projetoFapen.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoFapen.modelos.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
