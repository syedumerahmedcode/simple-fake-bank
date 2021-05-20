package com.umer.simplefakebank.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

	public static final String TABLE_PREFIX = "account_";

	@Id
	@Column(name = TABLE_PREFIX + "id")
	@GeneratedValue
	private Long id;

	@NotNull
	@Column(name = TABLE_PREFIX + "initial_deposit_amount")
	private BigDecimal initialDepositAmount;

	@NotNull
	@Column(name = TABLE_PREFIX + "creation_timestamp", columnDefinition = "TIMESTAMP")
	private LocalDateTime createTimestamp;

	@NotNull
	@Column(name = TABLE_PREFIX + "balance")
	private BigDecimal balance;

}
