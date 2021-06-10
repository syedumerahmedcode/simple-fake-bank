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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "New account created response.", description = "The new account information.")
public class ResponseAccountDTO {

	@JsonProperty("user_id")
	@ApiModelProperty(notes = "The Id of the customer of the owner of the account.")
	private Long userId;

	@JsonProperty("account_id")
	@ApiModelProperty(notes = "The account Id.")
	private Long id;

	@JsonProperty("balance")
	@ApiModelProperty(notes = "The balance of the account.")
	private BigDecimal balance;

	@JsonProperty("created_at")
	@ApiModelProperty(notes = "The date and time when the account was created.")
	private LocalDateTime creationTimestamp;

}
