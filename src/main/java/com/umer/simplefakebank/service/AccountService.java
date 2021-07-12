package com.umer.simplefakebank.service;

import static com.umer.simplefakebank.configuration.BankConstants.ERROR_ACCOUNT_NOT_FOUND;
import static com.umer.simplefakebank.configuration.BankConstants.ERROR_INSUFFICIENT_BALANCE;
import static com.umer.simplefakebank.configuration.BankConstants.ERROR_USER_NOT_FOUND;
import static com.umer.simplefakebank.service.mapper.BankMapper.toAccountEntity;
import static com.umer.simplefakebank.service.ServiceUtil.throwsOnCondition;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.umer.simplefakebank.dto.request.RequestAccountDTO;
import com.umer.simplefakebank.dto.response.ResponseAccountBalanceDTO;
import com.umer.simplefakebank.dto.response.ResponseAccountDTO;
import com.umer.simplefakebank.entities.Account;
import com.umer.simplefakebank.entities.User;
import com.umer.simplefakebank.exception.AccountNotFoundException;
import com.umer.simplefakebank.exception.InsufficientBalanceException;
import com.umer.simplefakebank.exception.InvalidRequestAccountException;
import com.umer.simplefakebank.exception.TransferNotAllowedException;
import com.umer.simplefakebank.exception.UserNotFoundException;
import com.umer.simplefakebank.repsitory.AccountReposoitory;
import com.umer.simplefakebank.repsitory.UserRepository;
import com.umer.simplefakebank.service.mapper.BankMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class AccountService {

	private final AccountReposoitory accountRepository;
	private final UserRepository userRepository;

	public ResponseAccountDTO createNewAccount(@Valid RequestAccountDTO requestAccountDTO) {
		log.debug("Creating a new account - {}", requestAccountDTO);

		// TODO: Throw error using a generic util class.
		if (Objects.isNull(requestAccountDTO)) {
			// Throw an exception
			throw new InvalidRequestAccountException();
		}
		final Long userId = requestAccountDTO.getUserId();
		User user = userRepository
				.findById(userId)
				.orElseThrow(() -> {
			log.error(ERROR_USER_NOT_FOUND, userId);
			throw new UserNotFoundException();
		});
		Account account = toAccountEntity(requestAccountDTO);

		// Set missing fields
		account.setUser(user);
		account.setBalance(account.getInitialDepositAmount());
		account.setCreationTimestamp(getCurrentTimestamp());

		account = accountRepository.save(account);

		log.debug("Created Account - {}", account);
		return BankMapper.toResponseAccountDTO(account);
	}

	public ResponseAccountBalanceDTO retrieveBalance(Long accountId) {
		log.debug("Retreiving balance from account Id: {}", accountId);
		Account account = accountRepository
				.findById(accountId)
				.orElseThrow(() -> {
			log.error(ERROR_ACCOUNT_NOT_FOUND, accountId);
			throw new AccountNotFoundException();
		});
		return ResponseAccountBalanceDTO
				.builder()
				.id(accountId)
				.balance(account.getBalance())
				.creationTimestamp(getCurrentTimestamp())
				.build();
	}
	
	Account getAccountById(Long accountId) {
		return accountRepository.findById(accountId)
				.orElseThrow(() ->{
					log.error(ERROR_ACCOUNT_NOT_FOUND, accountId);
					throw new AccountNotFoundException();
				});
	}

	public void transfer(Account senderAccount, Account receiverAccount, BigDecimal value) {
		log.debug("Starting transfer from sender account:[{}] to receiver account:[{}] --> amount[{}]", senderAccount,
				receiverAccount, value);
		
		throwsOnCondition(senderAccount.getBalance().compareTo(value) < 0,
                InsufficientBalanceException::new,
                String.format(ERROR_INSUFFICIENT_BALANCE, senderAccount.getId()));
        throwsOnCondition(senderAccount.equals(receiverAccount), TransferNotAllowedException::new);
        senderAccount.setBalance(senderAccount.getBalance().subtract(value));
        receiverAccount.setBalance(receiverAccount.getBalance().add(value));
        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);

		log.debug("Finished transfer from sender account:[{}] to receiver account:[{}] --> amount[{}]", senderAccount,
				receiverAccount, value);
	}
	
	 LocalDateTime getCurrentTimestamp() {
         return LocalDateTime.now();
 }

}
