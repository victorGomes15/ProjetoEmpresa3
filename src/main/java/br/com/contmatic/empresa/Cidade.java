package br.com.contmatic.empresa;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

// TODO: Auto-generated Javadoc
/**
 * The Class Cidade.
 */
public class Cidade {

	@NotNull(message = "Código não pode ser nulo")
	@Min(value = 1, message = "Código da cidade parte de {value}")
	/** The codigo. */
	private Integer codigo;

	/** The nome. */
	@NotBlank(message = "Nome da cidade não pode ser nula ou vazia")
	@Pattern(regexp = RegexCampos.NOME_CIDADE_FORMATO, message = "Nome da cidade não pode conter caracteres especiais")
	@Length(min = 3, max = 30, message = "Tamanho minimo da cidade igual 4 e máximo igual 30")
	private String nome;

	/** The bairro. */
	@NotNull(message = "Bairro nao pode ser nulo")
	private Bairro bairro;

	/**
	 * Instantiates a new cidade.
	 */
	public Cidade() {
	}

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome
	 *            the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the bairro.
	 *
	 * @return the bairro
	 */
	public Bairro getBairro() {
		return this.bairro;
	}

	/**
	 * Sets the bairro.
	 *
	 * @param bairro
	 *            the new bairro
	 */
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cidade)) {
			return false;
		}
		Cidade other = (Cidade) obj;

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
