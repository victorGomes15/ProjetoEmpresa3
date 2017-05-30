package br.com.contmatic.empresa;

/**
 * The Enum DDDsType.
 *
 * @author victor.silva
 */
public enum DDDsType {

	/** The dddmaximo. */
	DDDMAXIMO(99),
	/** The dddminimo. */
	DDDMINIMO(11);

	/** The valor. */
	private int valor;

	/**
	 * Instantiates a new DD ds type.
	 *
	 * @param valor
	 *            the valor
	 */
	private DDDsType(int valor) {
		this.valor = valor;
	}

	/**
	 * Gets the valor.
	 *
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

}
