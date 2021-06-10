package com.umer.simplefakebank.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseAccountDTO {
	
	@JsonProperty("user_id")
	private Long userId;
	
	@JsonProperty("account_id")
	private Long id;
	
	@JsonProperty("balance")
	private BigDecimal balance;
	
	@JsonProperty("created_at")
	private LocalDateTime creationTimestamp;

}
