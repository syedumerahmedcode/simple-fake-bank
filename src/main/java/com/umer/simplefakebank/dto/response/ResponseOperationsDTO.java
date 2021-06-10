package com.umer.simplefakebank.dto.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "List of operations response.", description = "List of operations collected for one given account Id.")
public class ResponseOperationsDTO {

	@JsonProperty("account_id")
	@ApiModelProperty(notes = "The id of the account.")
	private Long accountId;

	@JsonProperty("operations")
	@ApiModelProperty(notes = "List of operations for the given account Id.")
	private List<ResponseOperationDTO> operationDTOList = new ArrayList<>();

	@JsonProperty("created_at")
	@ApiModelProperty(notes = "Date and time when operation was collected.")
	private LocalDateTime creationTimestamp;

}
