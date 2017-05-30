package br.com.contmatic.empresa;

/**
 * The Enum EnderecoType.
 */
public enum EnderecoType {

	/** The comercial. */
	COMERCIAL("Comercial"), /** The fiscal. */
 FISCAL("Fiscal");

	/** The descricao. */
	private String descricao;

	/**
	 * Instantiates a new endereco type.
	 *
	 * @param descricao the descricao
	 */
	private EnderecoType(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
}
