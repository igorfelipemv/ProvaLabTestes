package com.fatec.scel;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.scel.model.Atendimento;
import com.fatec.scel.model.AtendimentoRepository;

@SpringBootTest
class REQ01CadastrarAgendamento {
	@Autowired
	AtendimentoRepository repository;
	private Validator validator;
	private ValidatorFactory validatorFactory;

	@Test
	void ct01_quando_dados_validos_isbn_nao_cadastrado_retorna1() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		// Dado – que o ISBN do livro não está cadastrado
		repository.deleteAll();
		// Quando – o usuário registra as informações do livro e confirma a operação
		Atendimento livro = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		Set<ConstraintViolation<Atendimento>> violations = validator.validate(livro);
		assertTrue(violations.isEmpty());
		repository.save(livro);
		// Então – o sistema valida as informações E retorna a quantidade de registros
		// inseridos igual a 1.
		assertEquals(1, repository.count());
	}

	@Test
	void ct02_quando_titulo_branco_retorna_msg_titulo_invalido() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		// Dado – que o ISBN do livro não está cadastrado
		repository.deleteAll();
		// Quando – o usuário nao informa o titulo e confirma a operação
		Atendimento livro = new Atendimento("11111111111", "123456", "05052020", "16:30", "consulta");
		Set<ConstraintViolation<Atendimento>> violations = validator.validate(livro);
		// Então – o sistema valida as informações E retorna mensagem titulo invalido.
		// assertFalse(violations.isEmpty());
		// assertEquals(violations.size(), 1);
		assertEquals("Titulo deve ter entre 1 e 50 caracteres", violations.iterator().next().getMessage());
	}
}