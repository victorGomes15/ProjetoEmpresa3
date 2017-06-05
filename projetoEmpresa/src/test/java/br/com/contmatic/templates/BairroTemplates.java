package br.com.contmatic.templates;

import br.com.contmatic.empresa.Bairro;
import br.com.contmatic.utils.RegexCampos;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class BairroTemplates implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Bairro.class).addTemplate("bairroValido", new Rule() {
			{
				add("codigo", random(Integer.class, range(1, 100)));
				add("nomeBairro", random("Ibirapuera", "Capao Redondo", "Tatuape"));
				add("cep", regex(RegexCampos.CEP_FORMATO));
			}
		});

		Fixture.of(Bairro.class).addTemplate("bairroInvalido", new Rule() {
			{
				add("codigo", -1);
				add("nomeBairro", random("Ib@@apuera", "::?? Redondo", "+-*#pe"));
				add("cep", "0");
			}
		});

	}

}
