package com.umer.simplefakebank.controller;

import org.springframework.web.bind.annotation.RestController;

import com.umer.simplefakebank.service.OperationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OperationController {

	public static final String OPERATION_END_POINT_V1 = "/v1/operations";
	public static final String OPERATION_GET_END_POINT = "/fromAccount/{accountId}";

	private final OperationService operationService;

}
