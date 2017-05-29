package br.com.contmatic.empresa;

public enum TelefoneType {

	CELULAR("Celular", 9), FIXO("Fixo", 8);

	private String descricao;
	private int tamanho;

	private TelefoneType(String descricao, int tamanho) {
		this.descricao = descricao;
		this.tamanho = tamanho;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getTamanho() {
		return tamanho;
	}

}
