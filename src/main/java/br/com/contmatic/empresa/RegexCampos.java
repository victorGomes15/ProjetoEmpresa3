package br.com.contmatic.empresa;

public final class RegexCampos {

	public final static String CEP_FORMATO = "\\d{8}";
	public final static String EMAIL_FORMATO = ".+@.+\\.[a-z]+";
	public final static String CNPJ_FORMATO = "\\d{14}";
	public final static String RUA_FORMATO = "[a-zA-Z\\+\\s_\\d]+";
	public final static String TELEFONE_FORMATO = "[0-9]{8,9}";
	public final static String UF_FORMATO = "[A-Z]{2}";
	public final static String RAZAO_SOCIAL_FORMATO = "[A-Za-z0-9]{1,30}";
	public final static String INSCRICAO_ESTADUAL_FORMATO = "[0-9]{13}";
	public final static String DONO_FORMATO = "^[A-Za-z]{4,50}";
	public final static String NOME_BAIRRO_FORMATO = "[A-Za-z0-9\\s]+";
	public final static String NOME_CIDADE_FORMATO = "[A-Za-z0-9\\s]+";
	public final static String NOME_EMPRESA_FORMATO = "[A-Za-z0-9]{5,20}";
}
