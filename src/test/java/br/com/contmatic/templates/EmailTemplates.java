package br.com.contmatic.templates;

import br.com.contmatic.empresa.Email;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmailTemplates implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Email.class).addTemplate("emailValido", new Rule() {
			{
				add("enderecoEmail", random("victor@gmail.com", "victor@gmail.com.br", "Josevictor@gmail.com"));
			}
		});

	}

}
