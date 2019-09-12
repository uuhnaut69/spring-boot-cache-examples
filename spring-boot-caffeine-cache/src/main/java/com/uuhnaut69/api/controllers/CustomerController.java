package com.uuhnaut69.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.entities.Customer;
import com.uuhnaut69.api.services.CustomerService;

import javassist.NotFoundException;

/**
 * @author uuhnaut
 *
 */
@RestController
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/getall")
	public List<Customer> getAll() {
		return customerService.getAll();
	}

	@GetMapping("/customer/{id}")
	public Customer getById(@PathVariable int id) throws NotFoundException {
		return customerService.getById(id);
	}

	@PostMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		customerService.deleteById(id);
	}

	@PostMapping("/create")
	public Customer create(@RequestBody Customer model) {
		return customerService.create(model);
	}
}
