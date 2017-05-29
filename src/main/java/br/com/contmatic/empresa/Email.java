package br.com.contmatic.empresa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

// TODO: Auto-generated Javadoc
/**
 * The Class Email.
 */
public class Email {

	/** The endereco email. */
	@NotBlank(message = "Email não pode ser nulo ou vazio")
	@org.hibernate.validator.constraints.Email(regexp = RegexCampos.EMAIL_FORMATO, message = "Email deve ser valido")
	private String enderecoEmail;

	/**
	 * Gets the endereco email.
	 *
	 * @return the endereco email
	 */
	public String getEnderecoEmail() {
		return enderecoEmail;
	}

	/**
	 * Sets the endereco email.
	 *
	 * @param enderecoEmail
	 *            the new endereco email
	 */
	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.enderecoEmail).toHashCode();
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
		Email other = (Email) obj;

		return new EqualsBuilder().append(this.enderecoEmail, other.enderecoEmail).isEquals();

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