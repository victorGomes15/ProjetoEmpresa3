package br.com.contmatic.empresa;

public enum DDDsType {
	DDDMAXIMO(99), DDDMINIMO(11);

	private int valor;

	private DDDsType(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

}
