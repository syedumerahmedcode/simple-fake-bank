package com.umer.simplefakebank.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
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
public class User {

	private static final String TABLE_PREFIX = "user_";

	@Id
	@Column(name = TABLE_PREFIX + "id")
	private Long id;

	// TODO: Break this in first_name and last_name fields.
	@NotNull
	@NotBlank(message = "Name is mandatory")
	@Column(name = TABLE_PREFIX + "name")
	private String name;

}
