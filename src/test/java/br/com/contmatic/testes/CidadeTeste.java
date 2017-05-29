package br.com.contmatic.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.Bairro;
import br.com.contmatic.empresa.Cidade;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class CidadeTeste {

	private Cidade cidade;
	private Bairro bairro;

	@BeforeClass
	public static void setUpClass() {

		System.out.println("Começo dos testes da classe " + CidadeTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownClass() {

		System.out.println("Fim dos testes da classe " + CidadeTeste.class.getSimpleName() + "\n");
	}

	@Before
	public void criar_objeto() {
		cidade = Fixture.from(Cidade.class).gimme("cidadeValida");
		System.out.println("Começo do teste");
	}

	@After
	public void finalizacao_Teste() {
		System.out.println("Fim de teste");
	}

	@Test
	public void nao_deve_aceitar_um_nome_nulo() {
		cidade.setNome(null);
		assertTrue(Validacao.vaidacoes(cidade));
	}

	@Test
	public void nao_deve_aceitar_um_nome_vazio() {
		cidade.setNome("");
		assertTrue(Validacao.vaidacoes(cidade));
	}

	@Test
	public void nao_deve_aceitar_um_nome_com_menos_de_3_caracteres() {
		cidade.setNome("It");
		assertTrue(Validacao.vaidacoes(cidade));
	}

	@Test
	public void deve_aceitar_um_nome_com_mais_de_2_caracteres() {
		cidade.setNome("Itu");
		assertFalse(Validacao.vaidacoes(cidade));
	}

	@Test
	public void printObj() {
		System.out.println(cidade);
	}

	@Test
	public void deve_aceitar_um_bairro_valido() {
		bairro = Fixture.from(Bairro.class).gimme("bairroValido");
		cidade.setBairro(bairro);
		Assert.assertFalse(Validacao.vaidacoes(cidade));
	}

	@Test
	public void nao_deve_aceitar_um_bairro_invalido() {
		cidade.setBairro(null);
		Assert.assertTrue(Validacao.vaidacoes(cidade));
	}

}
