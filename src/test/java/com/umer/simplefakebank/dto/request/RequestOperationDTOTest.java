package com.umer.simplefakebank.dto.request;

import static com.umer.simplefakebank.configuration.BankConstants.INVALID_ACCOUNT_ID;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RequestOperationDTOTest {

	private static final String INVALID_VALUE_FORMAT = "Invalid value format";
	private static final String MUST_NOT_BE_NULL = "must not be null";
	private static final String INVALID_VALUE = "Invalid value";
	private static Validator validator;

	@BeforeAll
	public static void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	void validOperationInputTest() {
		final long validSenderAccountId = 1L;
		final long validReceiverAccountId = 2L;
		final BigDecimal value = new BigDecimal("100.00");
		RequestOperationDTO requestOperationDTO = new RequestOperationDTO(validSenderAccountId, validReceiverAccountId,
				value);
		final Set<ConstraintViolation<RequestOperationDTO>> violations = validator.validate(requestOperationDTO);
		assertThat(violations.size()).isZero();
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(longs = { 0L })
	void checkViolations_WhenSenderAccountIsInvalid(Long invalidSenderAccount) {
		final long validReceiverAccountId = 2L;
		final BigDecimal value = new BigDecimal("100.00");
		RequestOperationDTO requestOperationDTO = new RequestOperationDTO(invalidSenderAccount, validReceiverAccountId,
				value);
		Set<ConstraintViolation<RequestOperationDTO>> violations = validator.validate(requestOperationDTO);
		assertThat(violations.size()).isEqualTo(1);
		// TODO: Think what is better, creating a parametrized test or creating two sseparate tests.
		if (invalidSenderAccount == null) {
			violationEqualsNullNotAllowed(violations);
		} else {
			violationEqualsInvalidAccountId(violations);
		}
	}

	
	
	@ParameterizedTest
	@NullSource
	@ValueSource(longs = { 0L })
	void checkViolations_WhenReceiverAccountIsInvalid(Long invalidReceiverAccount) {
		final long validSenderAccountId = 1L;
		final BigDecimal value = new BigDecimal("100.00");
		RequestOperationDTO requestOperationDTO = new RequestOperationDTO(validSenderAccountId, invalidReceiverAccount,
				value);
		Set<ConstraintViolation<RequestOperationDTO>> violations = validator.validate(requestOperationDTO);
		assertThat(violations.size()).isEqualTo(1);
		// TODO: Think what is better, creating a parametrized test or creating two sseparate tests.
		if (invalidReceiverAccount == null) {
			violationEqualsNullNotAllowed(violations);
		} else {
			violationEqualsInvalidAccountId(violations);
		}
	}
	
	@Test
	void checkViolations_WhenValueIsZero() {
		final long validSenderAccountId = 1L;
		final long validReceiverAccountId = 2L;
		final BigDecimal invalidValue = new BigDecimal("0.00");
		RequestOperationDTO requestOperationDTO = new RequestOperationDTO(validSenderAccountId, validReceiverAccountId,
				invalidValue);
		Set<ConstraintViolation<RequestOperationDTO>> violations = validator.validate(requestOperationDTO);
		assertThat(violations.size()).isEqualTo(1);
		vioationEqualsInvalidValue(violations);
		
	}
	
	@Test
	void checkViolations_WhenValueIsNegative() {
		final long validSenderAccountId = 1L;
		final long validReceiverAccountId = 2L;
		final BigDecimal invalidValue = new BigDecimal("-1.00");
		RequestOperationDTO requestOperationDTO = new RequestOperationDTO(validSenderAccountId, validReceiverAccountId,
				invalidValue);
		Set<ConstraintViolation<RequestOperationDTO>> violations = validator.validate(requestOperationDTO);
		assertThat(violations.size()).isEqualTo(1);
		vioationEqualsInvalidValue(violations);
		
	}

	
	
	@Test
	void checkViolations_WhenValueFractionPartIsMoreThanTwoDigits() {
		final long validSenderAccountId = 1L;
		final long validReceiverAccountId = 2L;
		final BigDecimal invalidValue = new BigDecimal("10.0001");
		RequestOperationDTO requestOperationDTO = new RequestOperationDTO(validSenderAccountId, validReceiverAccountId,
				invalidValue);
		Set<ConstraintViolation<RequestOperationDTO>> violations = validator.validate(requestOperationDTO);
		assertThat(violations.size()).isEqualTo(1);
		violations.forEach(action -> assertThat(action.getMessage())
				.isEqualTo(INVALID_VALUE_FORMAT));
		
	}

	private void violationEqualsNullNotAllowed(Set<ConstraintViolation<RequestOperationDTO>> violations) {
		violations.forEach(action -> assertThat(action.getMessage())
				.isEqualTo(MUST_NOT_BE_NULL));
	}
	
	private void violationEqualsInvalidAccountId(Set<ConstraintViolation<RequestOperationDTO>> violations) {
		violations.forEach(action -> assertThat(action.getMessage())
				.isEqualTo(INVALID_ACCOUNT_ID));
	}
	
	private void vioationEqualsInvalidValue(Set<ConstraintViolation<RequestOperationDTO>> violations) {
		violations.forEach(action -> assertThat(action.getMessage())
				.isEqualTo(INVALID_VALUE));
	}

}
