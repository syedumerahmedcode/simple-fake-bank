package com.umer.simplefakebank.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.umer.simplefakebank.dto.response.ResponseAccountBalanceDTO;
import com.umer.simplefakebank.service.AccountService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
	@ApiOperation(
			value = "Get account balance", notes = "Given an account Id, retrieves the balance.")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Account balance."),
			@ApiResponse(code = 404, message = "Account not found.")
	})
	public ResponseEntity<ResponseAccountBalanceDTO> getBalance(@PathVariable("id") final long accountId) {
		return ResponseEntity.ok(accountService.retrieveBalance(accountId));
	}

}
