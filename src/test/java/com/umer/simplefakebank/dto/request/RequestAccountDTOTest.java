package com.umer.simplefakebank.dto.request;

import static org.assertj.core.api.Assertions.assertThat;
import static com.umer.simplefakebank.configuration.BankConstants.*;

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
		final long validUserId = 1L;
		final BigDecimal validInitailDepositAmount = new BigDecimal("0.01");
		RequestAccountDTO requestAccountDTO = new RequestAccountDTO(validUserId, validInitailDepositAmount);
		Set<ConstraintViolation<RequestAccountDTO>> violations = validator.validate(requestAccountDTO);
		assertThat(violations.size()).isZero();
	}

	@Test
	void checkViolation_WhenUserIdIsInvalid() {
		final long invalidUserId = 0L;
		final BigDecimal validInitailDepositAmount = new BigDecimal("0.01");
		RequestAccountDTO requestAccountDTO = new RequestAccountDTO(invalidUserId, validInitailDepositAmount);
		Set<ConstraintViolation<RequestAccountDTO>> violations = validator.validate(requestAccountDTO);

		assertThat(violations.size()).isEqualTo(1);
		violations.forEach(action -> assertThat(action.getMessage())
				.isEqualTo(INVALID_USER_ID));
	}
	
	@Test
	void checkViolation_WhenInitialAmountIsInvalid() {
		final long validUserId = 1L;
		final BigDecimal invalidInitailDepositAmount = new BigDecimal("0.00");
		RequestAccountDTO requestAccountDTO=new RequestAccountDTO(validUserId, invalidInitailDepositAmount);
		Set<ConstraintViolation<RequestAccountDTO>> violations=validator.validate(requestAccountDTO);
		
		assertThat(violations.size()).isEqualTo(1);
		violations.forEach(action ->assertThat(action.getMessage())
				.isEqualTo(INVALID_INITIAL_AMOUNT));
		
	}

}
