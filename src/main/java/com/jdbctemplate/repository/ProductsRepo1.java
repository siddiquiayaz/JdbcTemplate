package com.jdbctemplate.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jdbctemplate.model.Product;
@Repository
public interface ProductsRepo1 extends JpaRepository<Product, Integer> {
	   @Query("SELECT p FROM Product p WHERE p.price != :price")
	    List<Product> findProductsNotPriced(@Param("price") double price);

}
