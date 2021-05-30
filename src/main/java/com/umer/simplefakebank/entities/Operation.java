package com.umer.simplefakebank.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Operation {

	public static final String TABLE_PREFIX = "operation_";

	@Id
	@Column(name = TABLE_PREFIX + "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = TABLE_PREFIX + "id_sender")
	private Account senderAccount;

	@ManyToOne
	@JoinColumn(name = TABLE_PREFIX + "id_receiver")
	private Account receiverAccount;

	@NotNull
	@Column(name = TABLE_PREFIX + "value")
	private BigDecimal value;

	@NotNull
	@Column(name = TABLE_PREFIX + "date_time", columnDefinition = "TIMESTAMP")
	private LocalDateTime operationDateTime;

}
