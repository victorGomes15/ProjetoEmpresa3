package br.com.contmatic.testes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.contmatic.empresa.Telefone;
import br.com.contmatic.empresa.TelefoneType;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class TelefoneTeste {

	private Telefone telefone;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Começo dos testes da classe " + TelefoneTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fim dos testes da classe " + TelefoneTeste.class.getSimpleName() + "\n");
	}

	@Before
	public void criar_objeto_telefone() {
		System.out.println("Começo do teste");
		telefone = Fixture.from(Telefone.class).gimme("telefoneValido");
	}

	@After
	public void finalizacao_Teste() {
		System.out.println("Fim de teste");
	}

	@Rule
	public ExpectedException expectEx = ExpectedException.none();

	@Test
	public void nao_deve_aceitar_ddd_menor_que_11() {
		telefone.setDdd(10);
		Assert.assertTrue(Validacao.vaidacoes(telefone));
	}

	@Test
	public void nao_deve_aceitar_ddd_maior_que_99() {
		telefone.setDdd(100);
		Assert.assertTrue(Validacao.vaidacoes(telefone));
	}

	@Test
	public void deve_aceitar_ddd_entre_11_e_99() {
		telefone.setDdd(20);
		Assert.assertFalse(Validacao.vaidacoes(telefone));
	}

	@Test
	public void deve_aceitar_8_ou_9_caracteres_no_numero() {
		telefone.setNumero("58254952");
		Assert.assertFalse(Validacao.vaidacoes(telefone));
	}

	@Test
	public void nao_deve_conter_menos_de_8_caracteres_no_numero() {
		telefone.setNumero("1234567");
		Assert.assertTrue(Validacao.vaidacoes(telefone));
	}

	@Test
	public void nao_deve_conter_mais_de_9_caracteres_no_numero() {
		telefone.setNumero("5825495210");
		Assert.assertTrue(Validacao.vaidacoes(telefone));
	}

	@Test
	public void nao_deve_aceitar_um_Numero_vazio() {
		telefone.setNumero("");
		Assert.assertTrue(Validacao.vaidacoes(telefone));
	}

	@Test
	public void nao_deve_aceitar_um_Numero_com_letras() {
		telefone.setNumero("5825495l");
		Assert.assertTrue(Validacao.vaidacoes(telefone));
	}

	@Test
	public void nao_deve_aceitar_um_Tipo_vazio() {
		String x = "";
		telefone.setTipo(TelefoneType.valueOf(x));
		Assert.assertTrue(Validacao.vaidacoes(telefone));
	}

	@Test
	public void nao_deve_aceitar_um_Tipo_nulo() {
		telefone.setTipo(null);
		Assert.assertTrue(Validacao.vaidacoes(telefone));
	}

	@Test
	public void nao_deve_aceitar_um_Tipo_com_numero() {
		String x = "fdf4";
		telefone.setTipo(TelefoneType.valueOf(x));
		Assert.assertTrue(Validacao.vaidacoes(telefone));
	}

	@Test
	public void nao_deve_aceitar_um_Tipo_diferente_de_celular_ou_fixo() {
		String x = "comercial";
		telefone.setTipo(TelefoneType.valueOf(x));
		Assert.assertTrue(Validacao.vaidacoes(telefone));
	}

	@Test
	public void deve_aceitar_um_Tipo_que_seja_igual_celular_ou_fixo() {
		String tipo = "FiXo";
		telefone.setTipo(TelefoneType.valueOf(tipo.toUpperCase()));
		Assert.assertFalse(Validacao.vaidacoes(telefone));
	}

	@Test
	public void print() {
		System.out.println(telefone);
	}

}
