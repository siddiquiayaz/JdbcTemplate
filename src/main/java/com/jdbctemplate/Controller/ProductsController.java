package com.jdbctemplate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbctemplate.Service.ProductService;
import com.jdbctemplate.model.Product;
import com.jdbctemplate.repository.ProductsRepo1;

@RestController
@RequestMapping ("/products")
public class ProductsController {
	
	@Autowired
	private ProductService productService;
	
	

	@PostMapping
	public ResponseEntity<Void> saveProducts(@RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
     
	@GetMapping
	public ResponseEntity<List> getAllProducts() {
		List<Product> product = productService.findAll();
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductsById(@PathVariable Long id) {
		Product product = productService.findById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

		productService.updateByid(id, product);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProducts(@PathVariable Long id) {
		productService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/notPriced/{price}")
	public ResponseEntity<?> getProduct(@PathVariable("price") double price){
		
		return ResponseEntity.status(HttpStatus.OK).body(productService.findAllProductsNotPriced(price));
		
	}

}
