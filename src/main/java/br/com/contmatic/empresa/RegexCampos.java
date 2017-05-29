package br.com.contmatic.empresa;

// TODO: Auto-generated Javadoc
/**
 * The Class RegexCampos.
 */
public final class RegexCampos {

	/** The Constant CEP_FORMATO. */
	public final static String CEP_FORMATO = "\\d{8}";

	/** The Constant EMAIL_FORMATO. */
	public final static String EMAIL_FORMATO = ".+@.+\\.[a-z]+";

	/** The Constant CNPJ_FORMATO. */
	public final static String CNPJ_FORMATO = "\\d{14}";

	/** The Constant RUA_FORMATO. */
	public final static String RUA_FORMATO = "[a-zA-Z\\+\\s_\\d]+";

	/** The Constant TELEFONE_FORMATO. */
	public final static String TELEFONE_FORMATO = "[0-9]{8,9}";

	/** The Constant UF_FORMATO. */
	public final static String UF_FORMATO = "[A-Z]{2}";

	/** The Constant RAZAO_SOCIAL_FORMATO. */
	public final static String RAZAO_SOCIAL_FORMATO = "[A-Za-z0-9]{1,30}";

	/** The Constant INSCRICAO_ESTADUAL_FORMATO. */
	public final static String INSCRICAO_ESTADUAL_FORMATO = "[0-9]{13}";

	/** The Constant DONO_FORMATO. */
	public final static String DONO_FORMATO = "^[A-Za-z]{4,50}";

	/** The Constant NOME_BAIRRO_FORMATO. */
	public final static String NOME_BAIRRO_FORMATO = "[A-Za-z0-9\\s]+";

	/** The Constant NOME_CIDADE_FORMATO. */
	public final static String NOME_CIDADE_FORMATO = "[A-Za-z0-9\\s]+";

	/** The Constant NOME_EMPRESA_FORMATO. */
	public final static String NOME_EMPRESA_FORMATO = "[A-Za-z0-9]{5,20}";
}
