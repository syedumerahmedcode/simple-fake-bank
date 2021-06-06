package com.umer.simplefakebank.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.umer.simplefakebank.configuration.BankConstants.*;;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Request new account.", description = "Required information to create a new account.")
public class RequestAccountDTO {

	@JsonProperty("user_id")
	@NotNull
	@Min(value = 1, message = INVALID_USER_ID)
	@ApiModelProperty(notes = "Customer id.")
	private Long userId;

	@JsonProperty("initial_amount")
	@NotNull
	@DecimalMin(value = "0.0", inclusive = false, message = INVALID_INITIAL_AMOUNT)
	@ApiModelProperty(notes = "Initial deposit amount, format 0.00")
	private BigDecimal initailDeposotAmount;

}
