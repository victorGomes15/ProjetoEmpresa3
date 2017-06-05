package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

/**
 * The Class GerenciadorTelefone.
 */
public class GerenciadorTelefone {

	/** The lista numeros. */
	@Valid
	private Set<Telefone> listaNumeros;

	/**
	 * Adds the telefone.
	 *
	 * @param telefone
	 *            the telefone
	 */
	public void addTelefone(@Valid Telefone telefone) {
		Preconditions.checkArgument(verificarTipoSeExiste(telefone), "Tipo de telefone já existente");
		listaNumeros.add(telefone);
	}

	/**
	 * Verificar tipo se existe.
	 *
	 * @param telefone
	 *            the telefone
	 * @return true, if successful
	 */
	private boolean verificarTipoSeExiste(Telefone telefone) {
		for (Telefone tele : listaNumeros) {
			if (tele.getTipo().getDescricao().equals(telefone.getTipo().getDescricao())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the lista numeros.
	 *
	 * @return the lista numeros
	 */
	public Set<Telefone> getListaNumeros() {
		return listaNumeros;
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
