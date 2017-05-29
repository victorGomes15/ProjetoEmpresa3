package br.com.contmatic.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TelefoneTeste.class, BairroTeste.class, CidadeTeste.class, EmailTeste.class, EmpresaTeste.class,
		EnderecoTeste.class, EstadoTeste.class })

public class AllTests {

}
