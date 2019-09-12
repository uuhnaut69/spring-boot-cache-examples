package com.uuhnaut69.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uuhnaut69.api.entities.Customer;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
