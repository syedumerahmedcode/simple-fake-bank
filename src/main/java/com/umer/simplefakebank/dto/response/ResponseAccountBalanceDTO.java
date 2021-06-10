package com.umer.simplefakebank.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "Account balance response.", description = "The balance of an account.")
public class ResponseAccountBalanceDTO {

	// TODO: The variable should be named account_id. Think about it!
	@JsonProperty("account_id")
	@ApiModelProperty(notes = "The Account Id.")
	private Long id;

	@JsonProperty("balance")
	@ApiModelProperty(notes = "Balance of an account.")
	private BigDecimal balance;

	@JsonProperty("created_at")
	@ApiModelProperty(notes = "The date and time when the balance was collected.")
	private LocalDateTime creationTimestamp;

}
