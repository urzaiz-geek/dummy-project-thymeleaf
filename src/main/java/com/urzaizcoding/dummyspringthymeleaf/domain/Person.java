package com.urzaizcoding.dummyspringthymeleaf.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.urzaizcoding.dummyspringthymeleaf.utils.UtilityClass;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Person")
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

	@Getter(value = AccessLevel.NONE)
	private static final String PERSON_SEQUENCE = "person_sequence";

	@Id
	@SequenceGenerator(name = PERSON_SEQUENCE, sequenceName = PERSON_SEQUENCE, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PERSON_SEQUENCE)
	private Long id;

	@Column(length = 50, nullable = false)
	private String firstname;

	@Column(length = 50)
	private String lastname;
	@Column(columnDefinition = "DATE", nullable = false)
	private LocalDate birthDate;
	@Column(length = 1, nullable = false)
	private Sex sex;
	
	@Column(length = 1, nullable = false)
	private MaritalStatus maritalStatus;
	
	@Column(length = 80)
	private String profession;

	private Float salary;
	private String photoPath;
	@Embedded
	private Address address;
	
	public String getSex() {
		return UtilityClass.capitalize(sex.name());
	}
	
	public String getMaritalStatus() {
		return UtilityClass.capitalize(maritalStatus.name());
	}
}
