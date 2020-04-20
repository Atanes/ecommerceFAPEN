package br.com.projetoFapen.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoFapen.modelos.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	boolean existsByCodigo(long codigo);
	boolean existsByEmail(String email);
	Usuario findByEmail(String email);

}
