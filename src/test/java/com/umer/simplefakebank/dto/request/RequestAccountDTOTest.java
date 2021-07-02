package com.umer.simplefakebank.dto.request;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RequestAccountDTOTest {

	private static Validator validator;

	@BeforeAll
	public static void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	void validUserIdTest() {
		RequestAccountDTO requestAccountDTO = new RequestAccountDTO(1L, new BigDecimal("0.01"));
		Set<ConstraintViolation<RequestAccountDTO>> violations = validator.validate(requestAccountDTO);
		assertThat(violations.size()).isZero();
	}

}
