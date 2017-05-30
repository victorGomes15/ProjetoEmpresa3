package br.com.contmatic.templates;

import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.GerenciadorEnderecos;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class GerenciadorEnderecoTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(GerenciadorEnderecos.class).addTemplate("gerenciador", new Rule() {
			{
				add("listaEndereco", has(0).of(Endereco.class, "enderecoValido"));
			}
		});
	}

}
