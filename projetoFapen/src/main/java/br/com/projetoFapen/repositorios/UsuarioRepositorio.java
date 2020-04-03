package br.com.projetoFapen.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoFapen.modelos.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
