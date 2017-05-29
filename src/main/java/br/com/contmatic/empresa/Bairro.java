package br.com.contmatic.empresa;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

// TODO: Auto-generated Javadoc
/**
 * The Class Bairro.
 */
public class Bairro {

	/** The codigo. */
	@NotNull(message = "Código do bairro não pode ser nulo")
	@Min(value = 1, message = "Código do bairro parte de {value}")
	private Integer codigo;

	/** The nome bairro. */
	@NotBlank(message = "Nome do bairro não pode ser nulo ou vazio")
	@Pattern(regexp = RegexCampos.NOME_BAIRRO_FORMATO, message = "Nome do bairro não pode conter caracteres especiais")
	@Size(min = 4, max = 20, message = "Tamanho minimo igual 4 e maximo igual a 20")
	private String nomeBairro;

	/** The cep. */
	@NotBlank(message = "Cep não pode ser nulo ou vazio")
	@Pattern(regexp = RegexCampos.CEP_FORMATO, message = "Cep só pode conter números")
	private String cep;

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the nome bairro.
	 *
	 * @return the nome bairro
	 */
	public String getNomeBairro() {
		return nomeBairro;
	}

	/**
	 * Sets the nome bairro.
	 *
	 * @param nomeBairro
	 *            the new nome bairro
	 */
	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	/**
	 * Gets the cep.
	 *
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Sets the cep.
	 *
	 * @param cep
	 *            the new cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Email)) {
			return false;
		}
		Bairro other = (Bairro) obj;

		return new EqualsBuilder().append(this.codigo, other.codigo).isEquals();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.codigo).toHashCode();
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
