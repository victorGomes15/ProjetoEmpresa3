package br.com.contmatic.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.GerenciadorEnderecos;
import br.com.contmatic.empresa.GerenciadorTelefone;
import br.com.contmatic.empresa.Telefone;
import br.com.contmatic.utils.Validacao;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTeste {

	private Empresa empresa;
	private Telefone telefone;
	private Endereco endereco;
	private GerenciadorTelefone telef;
	private GerenciadorEnderecos gerenEndereco;

	@BeforeClass
	public static void setUpClass() {
		System.out.println("Começo dos testes da classe " + EmpresaTeste.class.getSimpleName() + "\n");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.templates");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("Fim dos testes da classe" + EmpresaTeste.class.getSimpleName() + "\n");

	}

	@Before
	public void criarObj() {
		System.out.println("Começo do teste");
		empresa = Fixture.from(Empresa.class).gimme("empresaValida");
	}

	@After
	public void finalizacao_Teste() {
		System.out.println("Fim de teste");
	}

	@Test
	public void deve_aceitar_um_cnpj_valido_de_14_digitos() {
		empresa.setCnpj("12345678901234");
		Assert.assertTrue(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_um_cnpj_menor_14_caracteres() {
		empresa.setCnpj("1234567890123");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_um_cnpj_maior_14_caracteres() {
		empresa.setCnpj("123456789012345");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_um_cnpj_nulo() {
		empresa.setCnpj(null);
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void deve_aceitar_um_endereco_valido() {
		endereco = Fixture.from(Endereco.class).gimme("enderecoValido");
		gerenEndereco = Fixture.from(GerenciadorEnderecos.class).gimme("gerenciador");

		gerenEndereco.adcEndereco(endereco);
		empresa.setEndereco(gerenEndereco.getListaEndereco());
		Assert.assertTrue(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_site_invalido() {
		empresa.setSiteEmpresa("empresa.com");
		assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void deve_aceitar_site_valido() {
		empresa.setSiteEmpresa("http://empresa.com");
		assertTrue(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_um_cnpj_vazio() {
		empresa.setCnpj("");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_um_cnpj_com_letras() {
		empresa.setCnpj("12345678901234l");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	public void nao_deve_aceitar_um_dono_nulo() {
		empresa.setDono(null);
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_um_dono_vazio() {
		empresa.setDono("");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_um_dono_com_menos_de_4_caracteres() {
		empresa.setDono("Jos");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_um_dono_com_numeros() {
		empresa.setDono("Jose5");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_uma_inscricao_estadual_nula() {
		empresa.setInscricaoEstadual(null);
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_uma_inscricao_estadual_vazia() {
		empresa.setInscricaoEstadual("");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void deve_aceitar_uma_inscricao_com_13_caracteres() {
		empresa.setInscricaoEstadual("1234567891023");
		Assert.assertTrue(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_uma_inscricao_maior_que_13_caracteres() {
		empresa.setInscricaoEstadual("12345678910234");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_uma_inscricao_estadual_menor_que_13_caracteres() {
		empresa.setInscricaoEstadual("123456789012");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_uma_inscricao_estadual_com_letras() {
		empresa.setInscricaoEstadual("123456789102l");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void deve_aceitar_telefone_valido() {
		telefone = Fixture.from(Telefone.class).gimme("telefoneValido");
		telef = Fixture.from(GerenciadorTelefone.class).gimme("gerenciador");

		telef.addTelefone(telefone);

		empresa.setTelefone(telef.getListaNumeros());
		Assert.assertTrue(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_uma_razaoSocial_nula() {
		empresa.setRazaoSocial(null);
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_uma_razaoSocial_com_caracteres_especiais() {
		empresa.setRazaoSocial("luis@");
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_um_nome_de_empresa_nulo() {
		empresa.setRazaoSocial(null);
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_um_nome_de_empresa_vazia() {
		empresa.setRazaoSocial("");
		Assert.assertFalse("Razao valida", Validacao.notContainsError(empresa));
	}

	@Test
	public void deve_aceitar_uma_data_de_criacao() throws ParseException {
		empresa.setDataCriacao(DateTime.now().plusDays(1));
		System.out.println(empresa);
		Assert.assertTrue(Validacao.notContainsError(empresa));
	}

	@Test
	public void nao_deve_aceitar_uma_data_de_criacao_invalida() {
		empresa.setDataCriacao(DateTime.now().minusHours(1));
		Assert.assertFalse(Validacao.notContainsError(empresa));
	}

	@Test
	public void deve_printar_o_objeto_de_empresa() {
		System.out.println(empresa);
	}
}
