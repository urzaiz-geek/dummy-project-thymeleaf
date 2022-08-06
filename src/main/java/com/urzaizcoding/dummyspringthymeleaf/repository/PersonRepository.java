package com.urzaizcoding.dummyspringthymeleaf.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.urzaizcoding.dummyspringthymeleaf.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	@Query("select p from Person p where UPPER(p.firstname) like UPPER(CONCAT('%',:key,'%')) or UPPER(p.lastname) like UPPER(CONCAT('%',:key,'%'))")
	Page<Person> findByNameContaining(String key, Pageable page);
}