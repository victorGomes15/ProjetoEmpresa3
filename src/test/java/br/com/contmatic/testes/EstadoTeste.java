package br.com.contmatic.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.Cidade;
import br.com.contmatic.empresa.Estado;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EstadoTeste {

	private Estado estado;
	private Cidade cidade;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Começo dos testes da classe " + EstadoTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fim dos testes da classe " + EstadoTeste.class.getSimpleName() + "\n");
	}

	@Before
	public void criar_objeto() {
		estado = Fixture.from(Estado.class).gimme("estadoValido");
		System.out.println("Começo do teste ");
	}

	@After
	public void finalizacao_Teste() {
		System.out.println(estado);
		System.out.println("Fim de teste");
	}

	@Test
	public void nao_deve_aceitar_um_codigo_igual_a_0() {
		estado.setCod(0);
		assertTrue(Validacao.vaidacoes(estado));
	}

	@Test
	public void nao_deve_aceitar_uma_uf_nula() {
		estado.setUf(null);
		assertTrue(Validacao.vaidacoes(estado));
	}

	@Test
	public void nao_deve_aceitar_uma_uf_vazia() {
		estado.setUf("");
		assertTrue(Validacao.vaidacoes(estado));
	}

	@Test
	public void nao_deve_aceitar_uma_uf_com_mais_de_2_caracteres() {
		estado.setUf("paraiba");
		assertTrue(Validacao.vaidacoes(estado));
	}

	@Test
	public void nao_deve_aceitar_uma_uf_com_menos_de_2_caracteres() {
		estado.setUf("u");
		assertTrue(Validacao.vaidacoes(estado));
	}

	@Test
	public void deve_aceitar_uma_uf_com_2_caracteres() {
		estado.setUf("DF");
		assertFalse(Validacao.vaidacoes(estado));
	}

	@Test
	public void printObj() {
		System.out.println(estado);
	}

	@Test
	public void nao_deve_aceitar_uma_cidade_invalida() {
		cidade = Fixture.from(Cidade.class).gimme("cidadeValida");
		cidade.setNome(null);
		estado.setCidade(cidade);
		assertTrue(Validacao.vaidacoes(estado.getCidade()));
	}
	
	@Test
	public void nao_deve_aceitar_uma_cidade_nula() {
		estado.setCidade(cidade);
		assertTrue(Validacao.vaidacoes(estado));
	}

	@Test
	public void deve_aceitar_uma_cidade_valida() {
		cidade = Fixture.from(Cidade.class).gimme("cidadeValida");
		cidade.setCodigo(1);
		cidade.setNome("sao Paulo");

		estado.setCidade(cidade);

		Assert.assertNotNull(estado.getCidade());
	}

}
