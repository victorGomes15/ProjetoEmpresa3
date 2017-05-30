package br.com.contmatic.templates;

import br.com.contmatic.empresa.GerenciadorTelefone;
import br.com.contmatic.empresa.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class GerenciadorTelefoneTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(GerenciadorTelefone.class).addTemplate("gerenciador", new Rule() {
			{
				add("listaNumeros", has(1).of(Telefone.class, "telefoneValido"));
			}
		});
	}

}
