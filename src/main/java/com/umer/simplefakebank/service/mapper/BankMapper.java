package com.umer.simplefakebank.service.mapper;

import com.umer.simplefakebank.dto.request.RequestAccountDTO;
import com.umer.simplefakebank.dto.request.RequestOperationDTO;
import com.umer.simplefakebank.dto.response.ResponseAccountDTO;
import com.umer.simplefakebank.dto.response.ResponseOperationDTO;
import com.umer.simplefakebank.entities.Account;
import com.umer.simplefakebank.entities.Operation;

public class BankMapper {
	
	public static Account toAccountEntity(RequestAccountDTO requestAccountDTO) {
		return Account
				.builder()
				.initialDepositAmount(requestAccountDTO.getInitailDeposotAmount())
				.balance(requestAccountDTO.getInitailDeposotAmount())
				.build();
	}
	
	public static ResponseAccountDTO toResponseAccountDTO(Account account) {
		return ResponseAccountDTO
				.builder()
				.id(account.getId())
				.userId(account.getUser().getId())
				.balance(account.getBalance())
				.creationTimestamp(account.getCreateTimestamp())
				.build();				
	}
	

	public static Operation toOperationEntity(RequestOperationDTO requestOperationDTO) {
		return Operation
				.builder()
				// TODO: Check why sender and receiver are not needed here?
				.value(requestOperationDTO.getValue())
				.build();
	}
	
	public static ResponseOperationDTO toResponseOperationDTO(Operation operation) {
		return ResponseOperationDTO
				.builder()
				.id(operation.getId())
				.senderAccountId(operation.getSenderAccount().getId())
				.receiverAccountId(operation.getReceiverAccount().getId())
				.value(operation.getValue())
				.creationTimestamp(operation.getOperationDateTime())
				.build();		
	}

}
