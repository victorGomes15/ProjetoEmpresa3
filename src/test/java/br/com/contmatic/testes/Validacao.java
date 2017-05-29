package br.com.contmatic.testes;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Validacao {

	private static Validator validator;

	public static boolean vaidacoes(Object obj) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);

		if (constraintViolations.size() == 0) {
			return false;
		}

		for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
			System.err.println(constraintViolation.getMessage());
		}

		return true;
	}

}
