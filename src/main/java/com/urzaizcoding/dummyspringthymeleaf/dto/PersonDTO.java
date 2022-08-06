package com.urzaizcoding.dummyspringthymeleaf.dto;

import javax.validation.constraints.NotBlank;

import com.urzaizcoding.dummyspringthymeleaf.domain.Sex;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
	private Long id;
	@NotBlank
	private String firstname;
	private String lastname;
	@NotBlank
	private String birthDate;
	private Sex sex;
	private String profession;
	private Float salary;
	private String photoPath;
	private AddressDTO address;
}
