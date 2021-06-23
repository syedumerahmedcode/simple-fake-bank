package com.umer.simplefakebank.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.umer.simplefakebank.dto.request.RequestOperationDTO;
import com.umer.simplefakebank.dto.response.ResponseOperationDTO;
import com.umer.simplefakebank.dto.response.ResponseOperationsDTO;
import com.umer.simplefakebank.repsitory.OperationRepository;

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
	
	public ResponseOperationsDTO retrieveOperations(long account) {
		return null;
	}
	
	

}
