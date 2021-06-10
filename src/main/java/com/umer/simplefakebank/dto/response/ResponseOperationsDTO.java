package com.umer.simplefakebank.dto.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ResponseOperationsDTO {
	
	@JsonProperty("account_id")
	private Long accountId;
	
	@JsonProperty("operations")
	private List<ResponseOperationDTO> operationDTOList=new ArrayList<>();
	
	@JsonProperty("created_at")
	private LocalDateTime creationTimestamp;

}
