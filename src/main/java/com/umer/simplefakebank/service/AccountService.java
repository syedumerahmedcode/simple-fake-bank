package com.umer.simplefakebank.service;

import static com.umer.simplefakebank.configuration.BankConstants.ERROR_ACCOUNT_NOT_FOUND;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.umer.simplefakebank.dto.request.RequestAccountDTO;
import com.umer.simplefakebank.dto.response.ResponseAccountBalanceDTO;
import com.umer.simplefakebank.dto.response.ResponseAccountDTO;
import com.umer.simplefakebank.entities.Account;
import com.umer.simplefakebank.exception.AccountNotFoundException;
import com.umer.simplefakebank.repsitory.AccountReposoitory;
import com.umer.simplefakebank.repsitory.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class AccountService {

	private final AccountReposoitory accountReposoitory;
	private final UserRepository userRepository;

	
	public ResponseAccountDTO createNewAccount(@Valid RequestAccountDTO requestAccountDTO) {
		log.debug("Creatging a new account - {}", requestAccountDTO);

		
		ResponseAccountDTO responseAccountDTO=new ResponseAccountDTO();
		log.debug("Created Account - {}", responseAccountDTO);
		return responseAccountDTO;
	}
	
	public ResponseAccountBalanceDTO retrieveBalance(Long accountId) {
		log.debug("Retreiving balance from account Id: {}", accountId);
		Account account=accountReposoitory.findById(accountId)
				.orElseThrow(()->{
					log.error(ERROR_ACCOUNT_NOT_FOUND,accountId);
					throw new AccountNotFoundException();
				});
		return ResponseAccountBalanceDTO.builder()
				.id(accountId)
				.balance(account.getBalance())
				.creationTimestamp(LocalDateTime.now())
				.build();
	}

	public void transfer(Account senderAccount, Account receiverAccount, BigDecimal value) {
		log.debug("Starting transfer from sender account:[{}] to receiver account:[{}] --> amount[{}]", senderAccount,
				receiverAccount, value);
		
		

		log.debug("Finished transfer from sender account:[{}] to receiver account:[{}] --> amount[{}]", senderAccount,
				receiverAccount, value);
	}

}
