package com.group9fsd.SpringBootRestEasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group9fsd.SpringBootRestEasy.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
