package com.uuhnaut69.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.entities.Customer;
import com.uuhnaut69.api.services.CustomerService;

import javassist.NotFoundException;

/**
 * @author uuhnaut
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getAll() {
		List<Customer> list = customerService.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getById(@PathVariable int id) throws NotFoundException {
		Customer customer = customerService.getById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		customerService.deleteById(id);
		return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Customer> create(@RequestBody Customer model) {
		Customer customer = customerService.create(model);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
}
