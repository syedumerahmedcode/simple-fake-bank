package com.umer.simplefakebank.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.umer.simplefakebank.dto.response.ResponseAccountBalanceDTO;
import com.umer.simplefakebank.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountController {

	public static final String ACCOUNT_END_POINT_V1 = "/v1/accounts";
	public static final String ACCOUNT_GET_END_POINT_V1 = ACCOUNT_END_POINT_V1 + "/{id}";

	private final AccountService accountService;

	@GetMapping(
			path = ACCOUNT_GET_END_POINT_V1,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<ResponseAccountBalanceDTO> getBalance(@PathVariable("id") final long accountId) {
		return ResponseEntity.ok(accountService.retrieveBalance(accountId));
	}

}
