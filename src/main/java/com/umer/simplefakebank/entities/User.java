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

	@NotNull
	@NotBlank(message = "First name is mandatory.")
	@Column(name = TABLE_PREFIX + "first_name")
	private String firstName;

	@NotNull
	@NotBlank(message = "Last name is mandatory.")
	@Column(name = TABLE_PREFIX + "last_name")
	private String lastName;

}
