package br.com.contmatic.empresa;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

// TODO: Auto-generated Javadoc
/**
 * The Class Estado.
 */
public class Estado {

	/** The cod. */
	@NotNull(message = "Código do estado não pode ser nulo")
	@Min(value = 1, message = "Código do estado veve ser maior ou igual a 1")
	private Integer cod;

	/** The uf. */
	@NotBlank(message = "Unidade Federal não pode ser nula ou vazia")
	@Size(min = 2, max = 2, message = "Unidade Federal deve conter somente suas siglas")
	@Pattern(regexp = RegexCampos.UF_FORMATO, message = "Uf somente com letras maiusculas")
	private String uf;

	/** The cidade. */
	@NotNull(message = "Cidade não pode ser nula")
	private Cidade cidade;

	/**
	 * Instantiates a new estado.
	 */
	public Estado() {
	}

	/**
	 * Gets the cod.
	 *
	 * @return the cod
	 */
	public Integer getCod() {
		return cod;
	}

	/**
	 * Sets the cod.
	 *
	 * @param cod
	 *            the new cod
	 */
	public void setCod(Integer cod) {
		this.cod = cod;
	}

	/**
	 * Gets the uf.
	 *
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * Sets the uf.
	 *
	 * @param uf
	 *            the new uf
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * Gets the cidade.
	 *
	 * @return the cidade
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * Sets the cidade.
	 *
	 * @param cidade
	 *            the new cidade
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Estado)) {
			return true;
		}

		Estado other = (Estado) obj;
		return new EqualsBuilder().append(this.cod, other.cod).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.cod).hashCode();
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
