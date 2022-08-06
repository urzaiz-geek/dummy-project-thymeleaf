package com.urzaizcoding.dummyspringthymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {
	private String country;
	private String town;
	private String quarter;
	private String number;
	private String email;
}
