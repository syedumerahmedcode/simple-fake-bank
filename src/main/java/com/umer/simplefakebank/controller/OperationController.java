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

import org.springframework.http.MediaType;
import lombok.RequiredArgsConstructor;

/**
 * The operation controller exposes two endpoints:
 *  - GET
 *  	When account Id is given, it retrieves all of the operations.
 *  - POST
 *  	It creates a new transfer operation in your body the sender and receiver accounts ids and the value used
 *      in the transaction.
 * @author umer
 *
 */

@RestController
@RequiredArgsConstructor
public class OperationController {

	public static final String OPERATION_END_POINT_V1 = "/v1/operations";
	public static final String OPERATION_GET_END_POINT = "/fromAccount/{accountId}";

	private final OperationService operationService;

	@GetMapping(
			path = OPERATION_END_POINT_V1, 
			produces = MediaType.APPLICATION_JSON_VALUE			
	)
	public ResponseEntity<ResponseOperationsDTO> getOperations(@PathVariable("accountId") final long accountId) {
		return ResponseEntity.ok(operationService.retrieveOperations(accountId));
	}

	@PostMapping(path = "/tbd")
	public ResponseEntity reateNewOperation(@Valid @RequestBody RequestOperationDTO requestOperationDTO) {
		return null;
	}

}
