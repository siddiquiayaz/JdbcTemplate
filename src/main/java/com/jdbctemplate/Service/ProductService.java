package com.jdbctemplate.Service;

import java.util.List;

import com.jdbctemplate.model.Product;

public interface ProductService {
	public void saveProduct(Product product);

	public List<Product> findAll();

	public Product findById(Long id);

	public void updateByid(Long id, Product product);

	public void delete(Long id);
	
	List<Product> findAllProductsNotPriced(double price);
}
