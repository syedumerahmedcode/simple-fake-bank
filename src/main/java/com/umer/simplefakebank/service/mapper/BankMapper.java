package com.umer.simplefakebank.service.mapper;

import com.umer.simplefakebank.dto.request.RequestAccountDTO;
import com.umer.simplefakebank.dto.response.ResponseAccountDTO;
import com.umer.simplefakebank.entities.Account;

public class BankMapper {
	
	public static Account toAccountEntity(RequestAccountDTO requestAccountDTO) {
		return Account.builder()
				.initialDepositAmount(requestAccountDTO.getInitailDeposotAmount())
				.balance(requestAccountDTO.getInitailDeposotAmount())
				.build();
	}
	
	public static ResponseAccountDTO toResponseAccountDTO(Account account) {
		return ResponseAccountDTO.builder()
				.id(account.getId())
				.userId(account.getUser().getId())
				.balance(account.getBalance())
				.creationTimestamp(account.getCreateTimestamp())
				.build();				
	}
	
	

}
