package com.umer.simplefakebank.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.umer.simplefakebank.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountController {
	
	public static final String ACCOUNT_END_POINT_V1="/v1/accounts";
	public static final String ACCOUNT_GET_END_POINT_V1=ACCOUNT_END_POINT_V1+"/{id}";
	
	private final AccountService accountService;
	
	
	public void getBalance(@PathVariable("id") final long accountId) {
		
		accountService.createNewAccount(accountId);
		
	}

}
