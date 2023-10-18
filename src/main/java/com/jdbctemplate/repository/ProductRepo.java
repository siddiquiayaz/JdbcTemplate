package com.jdbctemplate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbctemplate.model.Product;

@Repository

public class ProductRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Product product) {
		String sql = "INSERT INTO products(productName,price) VALUES(?, ?)";
		jdbcTemplate.update(sql, product.getPrductName(), product.getPrice());

	}

	public List<Product> findAll() {

		String sql = "SELECT * FROM products";
		return jdbcTemplate.query(sql, (resultSet, row) -> {
			Product product = new Product();
			product.setId(resultSet.getLong("id"));
			product.setPrductName(resultSet.getString("productName"));
			product.setPrice(resultSet.getDouble("price"));
			return product;
		});

	}

	@SuppressWarnings("all")
	public Product findById(Long id) {
		String sql = "SELECT * FROM products WHERE id = ?";
		Product product = new Product();
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, (resultSet, rowNum) -> {
			Product product1 = new Product();
			product.setId(resultSet.getLong("id"));
			product.setPrductName(resultSet.getString("productName"));
			product.setPrice(resultSet.getDouble("price"));
			return product;
		});

	}

	public void updateByid(Long id, Product products) {
		String sql = "UPDATE  products SET productName =? , price =? WHERE id =?";
		jdbcTemplate.update(sql, products.getPrductName(), products.getPrice(), id);
	}

	public void delete(Long id) {
		String sql = "DELETE FROM products WHERE id =?";
		jdbcTemplate.update(sql, id);
	}

}
