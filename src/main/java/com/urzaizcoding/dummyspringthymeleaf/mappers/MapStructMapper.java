package com.urzaizcoding.dummyspringthymeleaf.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.urzaizcoding.dummyspringthymeleaf.domain.Person;
import com.urzaizcoding.dummyspringthymeleaf.dto.PersonDTO;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapStructMapper {
	Person personDTOToPerson(PersonDTO personResource);
	PersonDTO personToPersonDTO(Person personEntity);
}
