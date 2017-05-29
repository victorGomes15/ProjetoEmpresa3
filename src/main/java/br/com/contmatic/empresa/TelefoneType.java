package br.com.contmatic.empresa;

/**
 * The Enum TelefoneType.
 */
public enum TelefoneType {

	/** The celular. */
	CELULAR("Celular", 9),
	/** The fixo. */
	FIXO("Fixo", 8);

	/** The descricao. */
	private String descricao;

	/** The tamanho. */
	private int tamanho;

	/**
	 * Instantiates a new telefone type.
	 *
	 * @param descricao
	 *            the descricao
	 * @param tamanho
	 *            the tamanho
	 */
	private TelefoneType(String descricao, int tamanho) {
		this.descricao = descricao;
		this.tamanho = tamanho;
	}

	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Gets the tamanho.
	 *
	 * @return the tamanho
	 */
	public int getTamanho() {
		return tamanho;
	}

}
