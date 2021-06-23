package com.umer.simplefakebank.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umer.simplefakebank.dto.request.RequestOperationDTO;
import com.umer.simplefakebank.dto.response.ResponseOperationsDTO;
import com.umer.simplefakebank.service.OperationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OperationController {

	public static final String OPERATION_END_POINT_V1 = "/v1/operations";
	public static final String OPERATION_GET_END_POINT = "/fromAccount/{accountId}";
 
	private final OperationService operationService;
	
	
	@GetMapping(path = "/tbd")
	public ResponseEntity<ResponseOperationsDTO> getOperations(@PathVariable("accountId") final long accountId){
		return ResponseEntity.ok(operationService.retrieveOperations(accountId));
	}
	
	@PostMapping(path = "/tbd")
	public ResponseEntity reateNewOperation(@Valid @RequestBody RequestOperationDTO requestOperationDTO) {
		return null;
	}
	
	
	
}
