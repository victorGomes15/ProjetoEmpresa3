package br.com.contmatic.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.GerenciadorEnderecos;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class GerenciadorEnderecosTest {

	private GerenciadorEnderecos gerenciador;
	private Endereco endereco;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Começo dos testes da classe " + GerenciadorEnderecosTest.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Fim dos testes da classe " + GerenciadorEnderecosTest.class.getSimpleName() + "\n");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Começo do teste ");
		gerenciador = Fixture.from(GerenciadorEnderecos.class).gimme("gerenciador");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Fim dos testes da classe " + GerenciadorEnderecosTest.class.getSimpleName() + "\n");
	}

	@Test
	public void nao_deve_aeitar_um_endereco_invalido() {
		endereco = Fixture.from(Endereco.class).gimme("enderecoInvalido");
		gerenciador.adcEndereco(endereco);
		assertFalse(Validacao.validacoes(gerenciador));
	}

	@Test
	public void deve_aceitar_um_endereco_valido() {
		endereco = Fixture.from(Endereco.class).gimme("enderecoInvalido");
		gerenciador.adcEndereco(endereco);
		assertTrue(Validacao.validacoes(gerenciador));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_endereco_com_tipo_ja_existente() {
		endereco = Fixture.from(Endereco.class).gimme("enderecoInvalido");
		gerenciador.adcEndereco(endereco);
		gerenciador.adcEndereco(endereco);
	}

}
