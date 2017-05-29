package br.com.contmatic.templates;

import org.joda.time.DateTime;

import br.com.contmatic.empresa.Email;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.RegexCampos;
import br.com.contmatic.empresa.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaTemplates implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Empresa.class).addTemplate("empresaValida", new Rule() {
			{
				add("cnpj", regex(RegexCampos.CNPJ_FORMATO));
				add("dataCriacao", DateTime.now().plusDays(1));
				add("dono", random("Joao", "Jose", "Pedro", "Luis"));
				add("email", one(Email.class, "emailValido"));
				add("endereco", has(1).of(Endereco.class, "enderecoValido"));
				add("inscricaoEstadual", regex(RegexCampos.INSCRICAO_ESTADUAL_FORMATO));
				add("nomeEmpresa", random("Car System", "Micrsoft", "Super casinha"));
				add("razaoSocial", regex(RegexCampos.RAZAO_SOCIAL_FORMATO));
				add("telefone", has(1).of(Telefone.class, "telefoneValido"));
			}
		});

	}

}
