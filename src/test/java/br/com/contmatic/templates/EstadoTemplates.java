package br.com.contmatic.templates;

import br.com.contmatic.empresa.Cidade;
import br.com.contmatic.empresa.Estado;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EstadoTemplates implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Estado.class).addTemplate("estadoValido", new Rule() {
			{
				add("cidade", one(Cidade.class, "cidadeValida"));
				add("uf", random("SP", "RJ", "MG"));
				add("cod", random(Integer.class, range(1, 100)));
			}
		});

	}

}
