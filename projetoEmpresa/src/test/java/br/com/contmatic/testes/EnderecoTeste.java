package br.com.contmatic.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.Estado;
import br.com.contmatic.utils.Validacao;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EnderecoTeste {

	private Endereco endereco;
	private Estado estado;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Começo dos testes da classe " + EnderecoTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");

	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fim dos testes da classe " + EnderecoTeste.class.getSimpleName() + "\n");
	}

	@Before
	public void criar_endereco() {
		endereco = Fixture.from(Endereco.class).gimme("enderecoValido");
		System.out.println("Começo do teste " + EnderecoTeste.class);
	}

	@After
	public void finalizacao_Teste() {
		System.out.println("Fim de teste");
	}

	@Test
	public void nao_deve_aceitar_estado_nulo() {
		endereco.setEstado(estado);
		assertFalse(Validacao.notContainsError(endereco));
	}

	@Test
	public void nao_deve_aceitar_estado_invalido() {
		estado = Fixture.from(Estado.class).gimme("estadoInvalido");
		endereco.setEstado(estado);
		assertFalse(Validacao.notContainsError(endereco));
	}

	@Test
	public void nao_deve_aceitar_uma_rua_nula() {
		endereco.setRua(null);
		assertFalse(Validacao.notContainsError(endereco));
	}

	@Test
	public void nao_deve_aceitar_uma_rua_vazia() {
		endereco.setRua("");
		assertFalse(Validacao.notContainsError(endereco));
	}

	@Test
	public void nao_deve_aceitar_uma_rua_com_menos_de_4_caracteres() {
		endereco.setRua("cas");
		assertFalse(Validacao.notContainsError(endereco));
	}

	@Test
	public void deve_aceitar_uma_rua_com_mais_de_4_caracteres() {
		endereco.setRua("joao 12");
		assertTrue(Validacao.notContainsError(endereco));
	}

	@Test
	public void nao_deve_aceitar_uma_rua_com_caracteres_especiais() {
		endereco.setRua("J@nathan #");
		assertFalse(Validacao.notContainsError(endereco));
	}

	@Test
	public void deve_aceitar_um_numero_maior_que_0() {
		endereco.setNumero(1);
		assertTrue(Validacao.notContainsError(endereco));
	}

	@Test
	public void nao_deve_aceitar_um_numero_igual_a_0() {
		endereco.setNumero(0);
		assertFalse(Validacao.notContainsError(endereco));
	}

	@Test
	public void printObj() {
		System.out.println(endereco);
	}

	@Test
	public void deve_aceitar_um_complemento_maior_igual_a_0() {
		endereco.setComplemento(40);
		assertTrue(Validacao.notContainsError(endereco));
	}

	@Test
	public void nao_deve_aceitar_um_complemento_menor_que_0() {
		endereco.setComplemento(-1);
		assertFalse(Validacao.notContainsError(endereco));
	}

	@Test
	public void nao_deve_aceitar_um_complemento_maior_que_50() {
		endereco.setComplemento(60);
		assertFalse(Validacao.notContainsError(endereco));
	}

}