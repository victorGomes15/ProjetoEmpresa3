package br.com.contmatic.empresa;

public enum EnderecoType {

	COMERCIAL("Comercial"), FISCAL("Fiscal");

	private String descricao;

	private EnderecoType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
