package br.com.contmatic.templates;

import br.com.contmatic.empresa.Telefone;
import br.com.contmatic.empresa.TelefoneType;
import br.com.contmatic.utils.RegexCampos;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TelefoneTemplates implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Telefone.class).addTemplate("telefoneValido", new Rule() {
			{
				add("ddd", random(Integer.class, range(RegexCampos.DDD_MINIMO, RegexCampos.DDD_MAXIMO)));
				add("tipo", random((Object[]) TelefoneType.values()));
				add("numero", regex(RegexCampos.TELEFONE_FORMATO));
			}
		});

		Fixture.of(Telefone.class).addTemplate("telefoneInvalido", new Rule() {
			{
				add("ddd", 0);
				add("tipo", random((Object[]) TelefoneType.values()));
				add("numero", "9825495222");
			}
		});

	}

}
