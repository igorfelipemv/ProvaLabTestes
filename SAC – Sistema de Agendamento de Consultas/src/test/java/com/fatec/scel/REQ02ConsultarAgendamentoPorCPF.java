package com.fatec.scel;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.scel.model.Atendimento;
import com.fatec.scel.model.AtendimentoRepository;

@SpringBootTest
class REQ02ConsultarAgendamentoPorCPF {
	@Autowired
	AtendimentoRepository repository;

	@Test
	void ct01_quando_consulta_isbn_cadastrado_retorna_os_dados_do_livro() {
		// Dado – que o livro está cadastrado
		repository.deleteAll();
		Atendimento livro = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		repository.save(livro);
		// Quando – o usuário consulta o livro pelo isbn
		Atendimento ro = repository.findByIsbn("3333");
		// Então – o resultado obtido da consulta ao db deve ser igual a do objeto java
		// cadastrado
		assertThat(ro).isEqualTo(livro);
	}

	@Test
	void ct02_quando_consulta_titulo_parcial_retorna3() {
		// Dado – que existem 3 livros cadastrados com titulo teste
		repository.deleteAll();
		Atendimento atendimento = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		repository.save(atendimento);
		atendimento = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		repository.save(atendimento);
		atendimento = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		repository.save(atendimento);
		atendimento = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		repository.save(atendimento);
		// Quando – o usuário consulta pelo titulo teste
		atendimento = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		// Então – retorna 3 livros
		Atendimento ro = repository.findByIsbn("11111111111");
		assertThat(ro).isEqualTo(3);
	}

	@Test
	void ct03_quando_consulta_por_ordenacao_retorna_engenharia() {
		// Dado – que existem 4 livros cadastrados
		repository.deleteAll();
		Atendimento atendimento = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		repository.save(atendimento);
		atendimento = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		repository.save(atendimento);
		atendimento = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		repository.save(atendimento);
		atendimento = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		repository.save(atendimento);
		// Quando – consulta ordenado pelo titulo
		List<Atendimento> listRo = repository.buscaAtendimentosOrdenadoPorCPF();
		// Então – retorna engenharia
		assertThat(listRo.get(0).getCpfPaciente()).isEqualTo("1111111111111111");
	}
}