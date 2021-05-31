package com.umer.simplefakebank.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umer.simplefakebank.entities.Account;
import com.umer.simplefakebank.entities.User;
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

	//TODO: Further improvements:
	/*
	 * 1) Create mappers that contain user infomration 
	 * 2) Read Request DTO from Controller
	 * 3) Create a response mapper 
	 * 4) Return response mapper from this method to the controller
	 */
	public void createNewAccount(Long userId) {
		log.debug("Creatging a new account - {}", userId);

		// Get User from the Id
		Optional<User> user = userRepository.findById(userId);
		Account account=Account.builder().id(1L).initialDepositAmount(BigDecimal.valueOf(100L)).build();
		account= accountReposoitory.save(account);
		
		log.debug("Created Account - {}", account);
	}

}
