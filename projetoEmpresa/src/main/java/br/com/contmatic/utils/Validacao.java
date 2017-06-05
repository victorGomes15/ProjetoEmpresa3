package br.com.contmatic.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * The Class Validacao.
 */
public class Validacao {

	/** The validator. */
	private static Validator validator;

	/**
	 * Validacoes.
	 *
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 */
	public static boolean notContainsError(Object obj) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);

		if (constraintViolations.size() == 0) {
			return true;
		}

		for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
			System.err.println(constraintViolation.getMessage());
		}

		return false;
	}

}
