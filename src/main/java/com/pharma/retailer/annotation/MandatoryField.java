package com.pharma.retailer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//@Target({ ElementType.FIELD })
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MandatoryFieldValidator.class)
public @interface MandatoryField {
	// String message() default "This field is mandatory";
	String message() default "${mandatory.field.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
