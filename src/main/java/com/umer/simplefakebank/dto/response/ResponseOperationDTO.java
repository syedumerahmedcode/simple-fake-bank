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
@ApiModel(value = "Transfer response.", description = "Information after a transfer is executed.")
public class ResponseOperationDTO {

	// TODO: It should be operation_id. Think about it!
	@JsonProperty("operation_id")
	@ApiModelProperty(notes = "Transfer Id.")
	private Long id;

	@JsonProperty("sender_account_id")
	@ApiModelProperty(notes = "The account id of the sender.")
	private Long senderAccountId;

	@JsonProperty("receiver_account_id")
	@ApiModelProperty(notes = "The account id of the receiver.")
	private Long receiverAccountId;

	@JsonProperty("value")
	@ApiModelProperty(notes = "The value transferred.")
	private BigDecimal value;

	@JsonProperty("created_at")
	@ApiModelProperty(notes = "Transfer date time.")
	private LocalDateTime creationTimestamp;

}
