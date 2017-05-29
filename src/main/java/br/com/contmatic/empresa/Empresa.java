package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class Empresa.
 */
public class Empresa {

	/** The cnpj. */
	@NotNull(message = "CNPJ não deve ser nulo ou vazio")
	@Pattern(regexp = RegexCampos.CNPJ_FORMATO, message = "CNPJ deve ser valido")
	private String cnpj;

	/** The razao social. */
	@NotBlank(message = "Razão social não pode ser nula ou vazia")
	@Size(min = 2, max = 30)
	@Pattern(regexp = RegexCampos.RAZAO_SOCIAL_FORMATO)
	private String razaoSocial;

	/** The endereco. */
	private Set<Endereco> endereco;

	/** The telefone. */
	private Set<Telefone> telefone;

	/** The dono. */
	@NotBlank(message = "Dono não pode ser nulo ou vazio")
	@Pattern(regexp = RegexCampos.DONO_FORMATO, message = "Dono tem que ter um nome valido")
	private String dono;

	/** The email. */
	@NotNull(message = "Email não pode ser nulo")
	private Email email;

	/** The inscricao estadual. */
	@NotBlank(message = "Inscrição estadual não pode ser nula ou vazia")
	@Pattern(regexp = RegexCampos.INSCRICAO_ESTADUAL_FORMATO, message = "Inscrição estadula deve conter valores validos")
	private String inscricaoEstadual;

	/** The nome empresa. */
	@NotBlank(message = "Nome da empresa não pode ser nulo ou vazio")
	@Pattern(regexp = RegexCampos.NOME_BAIRRO_FORMATO)
	private String nomeEmpresa;

	/** The data criacao. */
	@NotNull(message = "Data de criação não pode ser nula")
	@Future(message = "Data de criação tem que ser data futura")
	private DateTime dataCriacao;

	/**
	 * Instantiates a new empresa.
	 */
	public Empresa() {
	}

	/**
	 * Gets the cnpj.
	 *
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Sets the cnpj.
	 *
	 * @param cnpj
	 *            the new cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Gets the razao social.
	 *
	 * @return the razao social
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * Sets the razao social.
	 *
	 * @param razaoSocial
	 *            the new razao social
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * Gets the endereco.
	 *
	 * @return the endereco
	 */
	public Set<Endereco> getEndereco() {
		return endereco;
	}

	/**
	 * Gets the telefone.
	 *
	 * @return the telefone
	 */
	public Set<Telefone> getTelefone() {
		return telefone;
	}

	/**
	 * Sets the telefone.
	 *
	 * @param telefone
	 *            the new telefone
	 */
	public void setTelefone(Set<Telefone> telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(Set<Endereco> endereco) {
		this.endereco = endereco;
	}

	/**
	 * Gets the dono.
	 *
	 * @return the dono
	 */
	public String getDono() {
		return dono;
	}

	/**
	 * Sets the dono.
	 *
	 * @param dono
	 *            the new dono
	 */
	public void setDono(String dono) {
		this.dono = dono;
	}

	/**
	 * Gets the data criacao.
	 *
	 * @return the data criacao
	 */
	public DateTime getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * Sets the data criacao.
	 *
	 * @param dataCriacao
	 *            the new data criacao
	 */
	public void setDataCriacao(DateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(Email email) {
		this.email = email;
	}

	/**
	 * Gets the inscricao estadual.
	 *
	 * @return the inscricao estadual
	 */
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	/**
	 * Sets the inscricao estadual.
	 *
	 * @param inscricaoEstadual
	 *            the new inscricao estadual
	 */
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	/**
	 * Gets the nome empresa.
	 *
	 * @return the nome empresa
	 */
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	/**
	 * Sets the nome empresa.
	 *
	 * @param nomeEmpresa
	 *            the new nome empresa
	 */
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.cnpj).hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Empresa)) {
			return false;
		}
		Empresa other = (Empresa) obj;
		return new EqualsBuilder().append(this.cnpj, other.cnpj).isEquals();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, new MultilineRecursiveToStringStyle());
	}

}
