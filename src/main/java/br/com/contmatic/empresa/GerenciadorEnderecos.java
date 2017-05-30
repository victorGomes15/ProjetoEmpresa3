package br.com.contmatic.empresa;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

public class GerenciadorEnderecos {

	@Valid
	private Set<Endereco> listaEndereco = new HashSet<>();

	public void adcEndereco(@Valid Endereco endereco) {
		Preconditions.checkArgument(verificarTipoEndereco(endereco), "Tipo de endereço já existente");
		listaEndereco.add(endereco);
	}

	private boolean verificarTipoEndereco(Endereco endereco) {
		for (Endereco endere : listaEndereco) {
			if (endere.getTipoEndereco().equals(endereco.getTipoEndereco())) {
				return false;
			}
		}
		return true;
	}

	public Set<Endereco> getListaEndereco() {
		return listaEndereco;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, new MultilineRecursiveToStringStyle());
	}

}
