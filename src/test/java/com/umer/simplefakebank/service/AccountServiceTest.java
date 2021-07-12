package com.umer.simplefakebank.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.umer.simplefakebank.dto.request.RequestAccountDTO;
import com.umer.simplefakebank.dto.response.ResponseAccountDTO;
import com.umer.simplefakebank.entities.Account;
import com.umer.simplefakebank.entities.User;
import com.umer.simplefakebank.exception.InvalidRequestAccountException;
import com.umer.simplefakebank.exception.UserNotFoundException;
import com.umer.simplefakebank.repsitory.AccountReposoitory;
import com.umer.simplefakebank.repsitory.UserRepository;
import com.umer.simplefakebank.service.mapper.BankMapper;


@ExtendWith(SpringExtension.class)
public class AccountServiceTest {

	@Mock
	private AccountReposoitory accountReposoitory;

	@Mock
	private UserRepository userRepository;
	
	@Mock
	private BankMapper bankMapper;

	@Spy
	@InjectMocks
	private AccountService accountService;

//	@Test
	void testCreateNewAccountSuccessfully() {

		Long userId = 1L;
		String username = "Username";
		Long accountId = 2L;
		BigDecimal initialAmount = BigDecimal.valueOf(10.01);

		RequestAccountDTO requestAccountDTO = RequestAccountDTO.builder()
				.userId(userId)
				.initailDepositAmount(initialAmount)
				.build();

		User user = User.builder()
				.name(username)
				.id(userId)
				.build();

		Account accountWithId =  Account.builder()
				.id(accountId)
                .initialDepositAmount(initialAmount)
                .creationTimestamp(LocalDateTime.MIN)
                .balance(initialAmount)
                .user(user)
                .build();

		Account accountWithoutId = Account.builder()
                .initialDepositAmount(initialAmount)
                .creationTimestamp(LocalDateTime.MIN)
                .balance(initialAmount)
                .user(user)
                .build();

		ResponseAccountDTO expectedResponseAccountDTO = ResponseAccountDTO.builder()
				.userId(userId)
                .id(accountId)
                .balance(initialAmount)
                .creationTimestamp(LocalDateTime.MIN)
                .build();

		when(userRepository.findById(userId)).thenReturn(Optional.ofNullable(user));
		when(accountReposoitory.save(accountWithoutId)).thenReturn(accountWithId);
		doReturn(LocalDateTime.MAX).when(accountService).getCurrentTimestamp();
		when(bankMapper.toResponseAccountDTO(accountWithId)).thenReturn(expectedResponseAccountDTO);
//		doReturn(expectedResponseAccountDTO).when(bankMapper).toResponseAccountDTO(accountWithId);

		ResponseAccountDTO actualResponseAccountDTO = accountService.createNewAccount(requestAccountDTO);
		Assertions.assertThat(actualResponseAccountDTO).isEqualTo(expectedResponseAccountDTO);

	}
	
	@Test
	void testCreateNewAccountWithNullRequest() {
		Throwable throwable = Assertions.catchThrowable(() -> accountService.createNewAccount(null));
		Assertions.assertThat(throwable).isInstanceOf(InvalidRequestAccountException.class);
	}
	
	@Test
	void testRequestAccountNotFoundForUserId() {
		Long someId = 1L;
		RequestAccountDTO requestAccountDTO=RequestAccountDTO.builder()
				.userId(someId)
				.build();
		when(userRepository.findById(someId)).thenReturn(Optional.empty());
		Throwable throwable = Assertions.catchThrowable(() -> accountService.createNewAccount(requestAccountDTO));
		Assertions.assertThat(throwable).isInstanceOf(UserNotFoundException.class);

	}

}
