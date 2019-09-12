package com.uuhnaut69.api.services;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.uuhnaut69.api.entities.Customer;
import com.uuhnaut69.api.repositories.CustomerRepository;

import javassist.NotFoundException;

/**
 * @author uuhnaut
 *
 */
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Cacheable(value = "customer", key = "#id")
	public Customer getById(int id) throws NotFoundException {
		return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found customer " + id));
	}

	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@CacheEvict(value = "customer")
	public void deleteById(int id) {
		customerRepository.deleteById(id);
	}

	@CachePut(value = "customer", key = "#model.id")
	public Customer create(Customer model) {
		Customer customer = new Customer();
		customer.setFirstName(model.getFirstName());
		customer.setLastName(model.getLastName());
		customer.setAge(model.getAge());
		customerRepository.save(customer);
		return customer;
	}
}
