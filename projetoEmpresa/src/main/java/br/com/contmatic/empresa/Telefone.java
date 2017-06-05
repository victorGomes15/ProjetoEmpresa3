package br.com.contmatic.empresa;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import br.com.contmatic.utils.RegexCampos;

/**
 * The Class Telefone.
 */
public class Telefone {

	/** The ddd. */
	@NotNull(message = "Ddd não pode ser nulo")
	@Min(value = RegexCampos.DDD_MINIMO, message = "Ddd minimo parte de {value}")
	@Max(value = RegexCampos.DDD_MAXIMO, message = "Ddd máximo igual a {value}")
	private Integer ddd;

	/** The numero. */
	@NotBlank(message = "Número não pode ser nulo ou vazio")
	@Pattern(regexp = RegexCampos.TELEFONE_FORMATO, message = "Telefone deve ter um número valido")
	private String numero;

	/** The tipo. */
	@NotNull(message = "Tipo de telefone não pode ser nulo")
	private TelefoneType tipo;

	/**
	 * Gets the ddd.
	 *
	 * @return the ddd
	 */
	public Integer getDdd() {
		return ddd;
	}

	/**
	 * Sets the ddd.
	 *
	 * @param ddd
	 *            the new ddd
	 */
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero
	 *            the new numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public TelefoneType getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo
	 *            the new tipo
	 */
	public void setTipo(TelefoneType tipo) {
		this.tipo = tipo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Telefone)) {
			return false;
		}
		Telefone other = (Telefone) obj;

		return new EqualsBuilder().append(this.ddd, other.ddd).append(this.numero, other.numero)
				.append(this.tipo, other.tipo).isEquals();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.ddd).append(this.numero).append(this.tipo).toHashCode();
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
