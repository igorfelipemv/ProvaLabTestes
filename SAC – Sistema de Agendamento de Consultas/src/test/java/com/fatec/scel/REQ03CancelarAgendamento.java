package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.scel.model.Atendimento;
import com.fatec.scel.model.AtendimentoRepository;

@SpringBootTest
class REQ03CancelarAgendamento {
	@Autowired
	AtendimentoRepository repository;

	@Test
	void ct01_quando_exclui_livro_consulta_retorna_null() {
		// Dado – que o livro está cadastrado
		repository.deleteAll();
		Atendimento livro = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		repository.save(livro);
		// Quando – o usuário solicita exclusao
		Atendimento ro = repository.findByIsbn("3333");
		repository.deleteById(ro.getId());
		// Então – o resultado obtido da consulta deve ser null
		assertThat(repository.findByIsbn("3333")).isEqualTo(null);
	}
}