package com.umer.simplefakebank.dto.request;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RequestOperationDTOTest {
	
	private static Validator validator;
	
	@BeforeAll
	public static void setUp() {
		validator=Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Test
	void validOperationInputTest() {
		final long validSenderAccountId = 1L;
		final long validReceiverAccountId = 2L;
		final BigDecimal value = new BigDecimal("100.00");
		RequestOperationDTO requestOperationDTO=new RequestOperationDTO(validSenderAccountId, validReceiverAccountId, value);
		final Set<ConstraintViolation<RequestOperationDTO>> violations = validator.validate(requestOperationDTO);
		assertThat(violations.size()).isZero();
	}

}
