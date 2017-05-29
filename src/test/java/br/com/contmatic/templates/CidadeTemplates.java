package br.com.contmatic.templates;

import br.com.contmatic.empresa.Bairro;
import br.com.contmatic.empresa.Cidade;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CidadeTemplates implements TemplateLoader {

	@Override
	public void load() {

		Fixture.of(Cidade.class).addTemplate("cidadeValida", new Rule() {
			{
				add("codigo", random(Integer.class, range(1, 100)));
				add("nome", random("Sao Paulo", "Rio de Janeiro", "Osasco"));
				add("bairro", one(Bairro.class, "bairroValido"));
			}
		});

	}

}
