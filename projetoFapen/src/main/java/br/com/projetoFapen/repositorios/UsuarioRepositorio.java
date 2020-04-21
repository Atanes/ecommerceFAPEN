package br.com.projetoFapen.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projetoFapen.modelos.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	
	boolean existsByCodigo(long codigo);
	boolean existsByEmail(String email);
	Usuario findByEmail(String email);
	
	Usuario findByEmailAndAtivoTrue(String email);
	
	@Query("select distinct p.nome from Usuario u inner join u.grupos g inner join g.permissoes p where u = ?1")
	List<String> listaPermissoes(Usuario u);

}
