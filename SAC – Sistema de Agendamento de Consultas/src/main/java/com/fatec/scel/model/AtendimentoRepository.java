package com.fatec.scel.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends CrudRepository<Atendimento, Long> {
	List<Atendimento> findAllByTituloIgnoreCaseContaining(String cpf);

	Atendimento findByIsbn(@Param("isbn") String isbn);

	@Query(value = "SELECT l FROM Atendimento l ORDER BY cpf")
	List<Atendimento> buscaAtendimentosOrdenadoPorCPF();
}