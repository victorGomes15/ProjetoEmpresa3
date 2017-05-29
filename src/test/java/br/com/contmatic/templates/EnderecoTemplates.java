package br.com.contmatic.templates;

import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.EnderecoType;
import br.com.contmatic.empresa.Estado;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EnderecoTemplates implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Endereco.class).addTemplate("enderecoValido", new Rule() {
			{
				add("rua", random("Rua x", "Rua y", "Rua z"));
				add("numero", random(Integer.class, range(1, 1000)));
				add("complemento", random(Integer.class, range(0, 100)));
				add("estado", one(Estado.class, "estadoValido"));
				add("tipoEndereco", random((Object[]) EnderecoType.values()));
			}
		});
	}

}
