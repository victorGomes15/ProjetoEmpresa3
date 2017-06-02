package br.com.contmatic.testes;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.contmatic.empresa.Bairro;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class BairroTeste {

	private Bairro bairro;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Começo testes da classe " + BairroTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fim dos testes da classe " + BairroTeste.class.getSimpleName() + "\n");
	}

	@Before
	public void criaObjt() {

		bairro = Fixture.from(Bairro.class).gimme("bairroValido");
		System.out.println("Começo de teste");
	}

	@After
	public void finalizacao_Teste() {
		System.out.println("Fim de teste");
	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void nao_deve_aceitar_um_codigo_igual_0() {
		bairro.setCodigo(0);
		assertFalse(Validacao.validacoes(bairro));
	}

	@Test
	public void nao_deve_aceitar_um_codigo_negativo() {
		bairro.setCodigo(-1);
		assertFalse(Validacao.validacoes(bairro));
	}

	@Test
	public void deve_aceitar_um_codigo_maior_que_0() {
		Bairro bairro2 = Fixture.from(Bairro.class).gimme("bairroValido");
		bairro2.setCodigo(20);
		Assert.assertTrue(Validacao.validacoes(bairro2));
	}

	@Test
	public void nao_deve_aceitar_um_bairro_nulo() {
		bairro.setNomeBairro(null);
		assertFalse(Validacao.validacoes(bairro));
	}

	@Test
	public void nao_deve_aceitar_um_bairro_vazio() {
		bairro.setNomeBairro("");
		assertFalse(Validacao.validacoes(bairro));
	}

	@Test
	public void nao_deve_aceitar_um_bairro_menor_que_4_caracteres() {
		bairro.setNomeBairro("cas");
		assertFalse(Validacao.validacoes(bairro));
	}

	@Test
	public void deve_aceitar_um_cep_valido() {
		Assert.assertNotNull(bairro.getCep());
	}

	@Test
	public void nao_deve_aceitar_um_cep_que_contenha_letras() {
		bairro.setCep("05857-38ç");
		assertFalse(Validacao.validacoes(bairro));
	}

	@Test
	public void nao_deve_aceitar_um_cep_que_contenha_caracteres_Especiais() {
		bairro.setCep("12345-17@");
		assertFalse(Validacao.validacoes(bairro));
	}

	@Test
	public void nao_deve_aceitar_um_cep_que_nulo() {
		bairro.setCep(null);
		assertFalse(Validacao.validacoes(bairro));
	}

	@Test
	public void nao_deve_aceitar_um_cep_que_esteja_vazio() {
		bairro.setCep("");
		assertFalse(Validacao.validacoes(bairro));
	}

	@Test
	public void printar_Objeto() {
		System.out.println(bairro);
	}

}
