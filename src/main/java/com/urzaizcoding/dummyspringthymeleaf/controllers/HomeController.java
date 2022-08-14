package com.urzaizcoding.dummyspringthymeleaf.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urzaizcoding.dummyspringthymeleaf.domain.Person;
import com.urzaizcoding.dummyspringthymeleaf.repository.PersonRepository;
import com.urzaizcoding.dummyspringthymeleaf.utils.ui.Paging;

@Controller
@RequestMapping(path = "/persons")
public class HomeController {

	private final PersonRepository personRepository;

	public HomeController(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@GetMapping
	public String persons(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "") String search, Model model) {

		Pageable pageObject = PageRequest.of(page, size, Sort.by(Order.asc("firstname"), Order.asc("lastname")));

		Page<Person> result = personRepository.findByNameContaining(search, pageObject);

		model.addAttribute("paging", new Paging(result.getTotalPages(), 5, page + 1));
		model.addAttribute("persons", result.getContent());
		model.addAttribute("search", search);
		return "persons";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id, @RequestParam String search, @RequestParam int page) {
		personRepository.deleteById(id);
		return String.format("redirect:/persons?page=%d&search=%s", page, search);
	}

}
