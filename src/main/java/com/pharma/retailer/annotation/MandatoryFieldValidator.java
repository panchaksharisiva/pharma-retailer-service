package com.pharma.retailer.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MandatoryFieldValidator implements ConstraintValidator<MandatoryField, String> {
	/*
	 * @Override public boolean isValid(String value, ConstraintValidatorContext
	 * context) { return value != null && !value.trim().isEmpty(); }
	 */

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("{mandatory.field.message}").addConstraintViolation();
			return false;
		}
		return true;
	}

}
