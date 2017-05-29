package br.com.contmatic.empresa;

import javax.validation.constraints.Max;
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
 * The Class Endereco.
 *
 * @author victor.silva
 */
public class Endereco {

	/** The rua. */
	@NotBlank(message = "Nome da rua não pode ser vazia ou nula")
	@Pattern(regexp = RegexCampos.RUA_FORMATO)
	@Size(min = 4, max = 10)
	private String rua;

	/** The numero. */
	@NotNull(message = "Número não pode ser nulo")
	@Min(value = 1, message = "Número minimo parti de {value}")
	/** The numero. */
	private Integer numero;

	/** The complemento. */
	@Min(value = 0, message = "Número para complemento deve parti de {value}")
	@Max(value = 50, message = "Número máximo para complento é {value}")
	/** The complemento. */
	private Integer complemento;

	/** The estado. */
	@NotNull(message = "Estado não pode ser nulo")
	/** The estado. */
	private Estado estado;

	/** The tipo endereco. */
	@NotNull(message = "Tipo de endereço não pode ser nulo")
	private EnderecoType tipoEndereco;

	/**
	 * Gets the rua.
	 *
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * Sets the rua.
	 *
	 * @param rua
	 *            the new rua
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero
	 *            the new numero
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * Gets the tipo endereco.
	 *
	 * @return the tipo endereco
	 */
	public EnderecoType getTipoEndereco() {
		return tipoEndereco;
	}

	/**
	 * Sets the tipo endereco.
	 *
	 * @param tipoEndereco
	 *            the new tipo endereco
	 */
	public void setTipoEndereco(EnderecoType tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	/**
	 * Gets the complemento.
	 *
	 * @return the complemento
	 */
	public Integer getComplemento() {
		return complemento;
	}

	/**
	 * Sets the complemento.
	 *
	 * @param complemento
	 *            the new complemento
	 */
	public void setComplemento(Integer complemento) {
		this.complemento = complemento;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado
	 *            the new estado
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.rua).append(this.numero).append(this.estado).append(this.complemento)
				.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;

		return new EqualsBuilder().append(this.rua, other.rua).append(this.numero, other.numero)
				.append(this.complemento, this.complemento).append(this.estado, other.estado).isEquals();
	}

}
