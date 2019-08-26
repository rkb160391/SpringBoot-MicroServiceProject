package com.rkb.app.controllers;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rkb.app.models.Person;

@RestController
class MyRestController {

	private final RestTemplate restTemplate;

	MyRestController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@RequestMapping("/message/{personId}")
	String getMessage(@PathVariable("personId") Long personId) {
		Person person = this.restTemplate.getForObject("http://localhost:8000/person/{personId}", Person.class, personId);
		return "Hello " + person.getName();
	}
	@GetMapping("/get")
	public String applicationIsUp() {
		return "MicroService is running...";
	}

}
