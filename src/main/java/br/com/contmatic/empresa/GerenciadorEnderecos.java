package br.com.contmatic.empresa;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

public class GerenciadorEnderecos {

	private Set<Endereco> listaEndereco = new HashSet<>();

	public void adcEndereco(Endereco endereco) {
		Preconditions.checkArgument(verificarTipoEndereco(endereco), "Tipo de endereço já existente");
		listaEndereco.add(endereco);
	}

	private boolean verificarTipoEndereco(Endereco endereco) {
		for (Endereco endere : listaEndereco) {
			if (endere.getTipoEndereco().equals(endereco)) {
				return false;
			}
		}
		return true;
	}

	public Set<Endereco> getListaEndereco() {
		return listaEndereco;
	}

}
