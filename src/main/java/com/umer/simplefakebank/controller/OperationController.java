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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
			path = OPERATION_GET_END_POINT, 
			produces = MediaType.APPLICATION_JSON_VALUE			
	)
	@ApiOperation(
			value = "Retrieves the transaction history for a given account.", 
			notes = "Given the account Id, it retriieves the operations/transfer wher this account has participated.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List of operations."),
			@ApiResponse(code = 404, message = "Account not found.")
	})
	public ResponseEntity<ResponseOperationsDTO> getOperations(@PathVariable("accountId") final long accountId) {
		return ResponseEntity.ok(operationService.retrieveOperations(accountId));
	}

	@PostMapping(
			path = OPERATION_END_POINT_V1,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	@ApiOperation(
			value = "Creates a new transfer.",
			notes = "Transfers amount between any two accounts, including those owned by different customers."
	)
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "Transfer created."),
			@ApiResponse(code = 404, message = "Sender/reciever account not found."),
			@ApiResponse(code = 400, message= "Sender/reciever account id is negative, Insufficient balance to transfer, same account used in the transfer operation.")
	})
	public ResponseEntity reateNewOperation(@Valid @RequestBody RequestOperationDTO requestOperationDTO) {
		// TODO: Implement controller and service methods.
		return null;
	}

}
