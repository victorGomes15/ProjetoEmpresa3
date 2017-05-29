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

public class Telefone {

	@NotNull(message = "Ddd não pode ser nulo")
	@Min(value = 11, message = "Ddd minimo parte de {value}")
	@Max(value = 99, message = "Ddd máximo igual a {value}")
	private Integer ddd;
	@NotBlank(message = "Número não pode ser nulo ou vazio")
	@Pattern(regexp = RegexCampos.TELEFONE_FORMATO, message = "Telefone deve ter um número valido")
	private String numero;
	@NotNull(message = "Tipo de telefone não pode ser nulo")
	private TelefoneType tipo;

	public Telefone() {
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TelefoneType getTipo() {
		return tipo;
	}

	public void setTipo(TelefoneType tipo) {
		this.tipo = tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Telefone)) {
			return false;
		}
		Telefone other = (Telefone) obj;

		return new EqualsBuilder().append(this.ddd, other.ddd).append(this.numero, other.numero)
				.append(this.tipo, other.tipo).isEquals();

	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.ddd).append(this.numero).append(this.tipo).toHashCode();
	}

	@Override
	public String toString() {
		new MultilineRecursiveToStringStyle();
		return ToStringBuilder.reflectionToString(this, MultilineRecursiveToStringStyle.SHORT_PREFIX_STYLE);

	}
}
