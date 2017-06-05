package br.com.contmatic.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.GerenciadorTelefone;
import br.com.contmatic.empresa.Telefone;
import br.com.contmatic.utils.Validacao;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class GerenciadorTelefoneTeste {

	private Telefone telefone;
	private GerenciadorTelefone gereciador;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Começo dos testes da classe " + GerenciadorTelefoneTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Fim dos testes da classe " + GerenciadorTelefoneTeste.class.getSimpleName() + "\n");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Começo do teste ");
		gereciador = Fixture.from(GerenciadorTelefone.class).gimme("gerenciador");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Fim do teste ");
	}

	@Test
	public void deve_aceitar_um_telefone_valido() {
		telefone = Fixture.from(Telefone.class).gimme("telefoneValido");
		gereciador.addTelefone(telefone);
		assertTrue(Validacao.notContainsError(gereciador));
	}

	@Test
	public void printar_objeto() {
		System.out.println(gereciador.getListaNumeros());
	}

	@Test
	public void nao_deve_aceitar_um_telefone_invalido() {
		telefone = Fixture.from(Telefone.class).gimme("telefoneInvalido");
		gereciador.addTelefone(telefone);
		assertFalse(Validacao.notContainsError(gereciador));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_um_telefone_com_o_mesmo_tipo_já_existente() {
		telefone = Fixture.from(Telefone.class).gimme("telefoneValido");
		gereciador.addTelefone(telefone);
		gereciador.addTelefone(telefone);
	}

}
