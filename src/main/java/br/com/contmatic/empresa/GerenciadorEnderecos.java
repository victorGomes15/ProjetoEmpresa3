package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

/**
 * The Class GerenciadorEnderecos.
 */
public class GerenciadorEnderecos {

	/** The lista endereco. */
	@Valid
	private Set<Endereco> listaEndereco;

	/**
	 * Adc endereco.
	 *
	 * @param endereco
	 *            the endereco
	 */
	public void adcEndereco(@Valid Endereco endereco) {
		Preconditions.checkArgument(verificarTipoEndereco(endereco), "Tipo de endereço já existente");
		listaEndereco.add(endereco);
	}

	/**
	 * Verificar tipo endereco.
	 *
	 * @param endereco
	 *            the endereco
	 * @return true, if successful
	 */
	private boolean verificarTipoEndereco(Endereco endereco) {
		for (Endereco endere : listaEndereco) {
			if (endere.getTipoEndereco().equals(endereco.getTipoEndereco())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the lista endereco.
	 *
	 * @return the lista endereco
	 */
	public Set<Endereco> getListaEndereco() {
		return listaEndereco;
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
