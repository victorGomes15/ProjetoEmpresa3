package br.com.contmatic.empresa;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

public class GerenciadorTelefone {

	private Set<Telefone> listaNumeros = new HashSet<>();

	public void addTelefone(Telefone telefone) {
		Preconditions.checkArgument(verificarTipoSeExiste(telefone), "Telefone já existente");
		listaNumeros.add(telefone);
	}

	private boolean verificarTipoSeExiste(Telefone telefone) {
		for (Telefone tele : listaNumeros) {
			if (tele.getTipo().getDescricao().equals(telefone.getTipo().getDescricao())) {
				return false;
			}
		}
		return true;
	}

	public Set<Telefone> getListaNumeros() {
		return listaNumeros;
	}

}
