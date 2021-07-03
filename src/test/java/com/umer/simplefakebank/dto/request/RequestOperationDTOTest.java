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
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RequestOperationDTOTest {

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
		if (invalidSenderAccount == null) {
			violations.forEach(action -> assertThat(action.getMessage())
					.isEqualTo("must not be null"));
		} else {
			violations.forEach(action -> assertThat(action.getMessage())
					.isEqualTo(INVALID_ACCOUNT_ID));
		}
	}

}
