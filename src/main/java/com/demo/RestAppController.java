package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Person;

@RestController
public class RestAppController {
	
	@Autowired
	MongoTemplate mongoTemplate;

	
	@PostMapping(path = "/person")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		mongoTemplate.save(person);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
	
	@GetMapping(path = "/person")
	public ResponseEntity<List<Person>> getAllPersons() {
		return new ResponseEntity<>(mongoTemplate.findAll(Person.class), HttpStatus.OK);
	}

}
