package com.fatec.scel.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	List<Usuario> findAllByNomeIgnoreCaseContaining(String nome);
	Usuario findByRa(@Param("ra")String ra);
	@Query(value = "SELECT l FROM Usuario l ORDER BY nome")
	List<Usuario> buscaTodosUsuariosOrdenadosPorNome();
	
}
