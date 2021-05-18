package com.group9fsd.SpringBootRestEasy.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.group9fsd.SpringBootRestEasy.entity.Product;

@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Long> {
	Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

	Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
