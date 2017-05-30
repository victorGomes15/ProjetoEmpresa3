package br.com.contmatic.testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.empresa.Estado;
import br.com.contmatic.empresa.GerenciadorTelefone;
import br.com.contmatic.empresa.Telefone;
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
	}

	@Test
	public void printar_objeto() {
		System.out.println(gereciador);
	}

	@Test
	public void nao_deve_aceitar_um_telefone_invalida() {
		telefone = Fixture.from(Telefone.class).gimme("telefoneInvalido");
		gereciador.addTelefone(telefone);
		assertFalse(Validacao.validacoes(gereciador));
	}

}
