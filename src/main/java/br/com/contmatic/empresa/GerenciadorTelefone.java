package br.com.contmatic.empresa;

import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Preconditions;

public class GerenciadorTelefone {

	@Valid
	private Set<Telefone> listaNumeros;

	public void addTelefone(@Valid Telefone telefone) {
		Preconditions.checkArgument(verificarTipoSeExiste(telefone), "Tipo de telefone já existente");
		listaNumeros.add(telefone);
	}

	private boolean verificarTipoSeExiste(@Valid Telefone telefone) {
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, new MultilineRecursiveToStringStyle());
	}

}
