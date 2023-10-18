package com.jdbctemplate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbctemplate.model.Product;
import com.jdbctemplate.repository.ProductRepo;
import com.jdbctemplate.repository.ProductsRepo1;

@Service
public class ProducServiceImp implements ProductService {
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	private ProductsRepo1 productsRepo1;

	@Override
	public void saveProduct(Product product) {

		productRepo.save(product);
	}

	@Override
	public List<Product> findAll() {

		return productRepo.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productRepo.findById(id);
	}

	@Override
	public void updateByid(Long id, Product product) {

		productRepo.updateByid(id, product);

	}

	@Override
	public void delete(Long id) {
		productRepo.delete(id);

	}

	public List<Product> findAllProductsNotPriced(double price) {
	    return productsRepo1.findProductsNotPriced(price);
	}


}
