package com.umer.simplefakebank.dto;

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
@ApiModel( value = "Customer/owner account information", description = "Id and name of the customer." )
public class UserDTO {
	
	// TODO: Add Access, datatype and example
	@ApiModelProperty(name = "Customer Id")
	private Long Id;
	
	// TODO: Add Access, datatype and example
	@ApiModelProperty(name="Name of the customer.")
	private String name;
	

}
