package com.umer.simplefakebank.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.umer.simplefakebank.dto.request.RequestOperationDTO;
import com.umer.simplefakebank.dto.response.ResponseOperationDTO;
import com.umer.simplefakebank.dto.response.ResponseOperationsDTO;
import com.umer.simplefakebank.entities.Account;
import com.umer.simplefakebank.repsitory.OperationRepository;
import com.umer.simplefakebank.service.mapper.BankMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class OperationService {

	private final AccountService accountService;
	private final OperationRepository operationRepository;

	public ResponseOperationDTO createNewOperation(@Valid RequestOperationDTO requestOperationDTO) {
		return null;
	}

	public ResponseOperationsDTO retrieveOperations(long accountId) {
		log.debug("Retriving operations for the account: {}", accountId);

		// fetch the account for the given accountId
		// TODO: Create a method out of it for cleaner code.
		Account account = accountService.getAccountById(accountId);
		List<ResponseOperationDTO> operationDTOList = operationRepository
				.findAllBySenderAccount_IdOrReceiverAccount_IdOrderByOperationDateTimeDesc(account.getId(),
						account.getId())
				.orElse(new ArrayList<>()).stream().map(BankMapper::toResponseOperationDTO)
				.collect(Collectors.toList());
		return ResponseOperationsDTO.builder().accountId(accountId).operationDTOList(operationDTOList)
				.creationTimestamp(getCurrentTimestamp()).build();

	}
	
	public ResponseOperationDTO createOperationService(@Valid RequestOperationDTO requestOperationDTO) {
		log.debug("Creating a new operation - {}", requestOperationDTO);
		
		// TODO: Implement logic!!!
		return null;
		
	}

	LocalDateTime getCurrentTimestamp() {
		return LocalDateTime.now();
	}

}
