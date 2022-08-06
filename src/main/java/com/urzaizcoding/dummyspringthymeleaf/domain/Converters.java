package com.urzaizcoding.dummyspringthymeleaf.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


public class Converters {
	
	public static class ListToCSVStringConverter implements AttributeConverter<List<String>, String> {
		private final String SEP_CHAR = ";";

		@Override
		public String convertToDatabaseColumn(List<String> attributes) {
			if(attributes.isEmpty())
				return "";
			return attributes.stream().reduce("", (l1, l2) -> l1 + ";" + l2).substring(1);
		}

		@Override
		public List<String> convertToEntityAttribute(String dbData) {
			return Arrays.stream(dbData.split(SEP_CHAR)).collect(Collectors.toCollection(ArrayList::new));
		}

	}
	
	@Converter(autoApply = true)
	public static class MaritalStatusConverter implements AttributeConverter<MaritalStatus, String> {

		@Override
		public String convertToDatabaseColumn(MaritalStatus attribute) {
			return attribute.getCode();
		}

		@Override
		public MaritalStatus convertToEntityAttribute(String dbData) {
			return Arrays.stream(MaritalStatus.values()).filter(m -> m.getCode().equals(dbData)).findFirst()
					.orElseThrow(IllegalArgumentException::new);
		}

	}

	@Converter(autoApply = true)
	public static class SexConverter implements AttributeConverter<Sex, String> {

		@Override
		public String convertToDatabaseColumn(Sex attribute) {
			return attribute.getCode();
		}

		@Override
		public Sex convertToEntityAttribute(String dbData) {
			return Arrays.stream(Sex.values()).filter(m -> m.getCode().equals(dbData)).findFirst()
					.orElseThrow(IllegalArgumentException::new);
		}

	}
}
