package com.umer.simplefakebank.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.umer.simplefakebank.repsitory.AccountReposoitory;
import com.umer.simplefakebank.repsitory.UserRepository;

@ExtendWith(SpringExtension.class)
public class AccountServiceTest {

	@Mock
	private AccountReposoitory accountReposoitory;
	
	@Mock
	private UserRepository userRepository;
	
	@Spy 
	@InjectMocks
	private AccountService accountService;
	
	@Test
	void testCreateNewAccountSuccessfully() {
		
	}

}
