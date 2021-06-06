package com.umer.simplefakebank.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.umer.simplefakebank.configuration.BankConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Transfer request.", description = "Account ids of sender and receiver and the amount to be transferred.")
public class RequestOperationDTO {

	// TODO: Check if further attributes of APIModelProperties should be applied on
	// fields.
	// TODO: Check if further attributes of JsonProperty should be applied on
	// fields.
	@JsonProperty("sender_account_id")
	@NotNull
	@Min(value = 1, message = INVALID_ACCOUNT_ID)
	@ApiModelProperty(notes = "Account id of sender.")
	private Long senderAccountId;

	@JsonProperty("receiver_account_id")
	@NotNull
	@Min(value = 1, message = INVALID_ACCOUNT_ID)
	@ApiModelProperty(notes = "Account id of receiver.")
	private Long receiverAccountId;

	@JsonProperty("value")
	@NotNull
	@DecimalMin(value = "0.0", inclusive = false, message = INVALID_VALUE)
	@Digits(integer = 12, fraction = 2, message = INVALID_VALUE_FORMAT)
	@ApiModelProperty(notes = "Amount to be transferred from the sender account to the receiver account.")
	private BigDecimal value;

}
