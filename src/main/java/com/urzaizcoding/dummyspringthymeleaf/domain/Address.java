package com.urzaizcoding.dummyspringthymeleaf.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	@Column(length = 80)
	private String country;
	@Column(length = 80)
	private String town;
	@Column(length = 80)
	private String quarter;
	@Column(nullable = false, length = 20, unique = true)
	private String number;
	@Column(nullable = false, length = 90, unique = true)
	private String email;
}
