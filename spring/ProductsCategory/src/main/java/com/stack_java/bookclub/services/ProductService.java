package com.stack_java.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack_java.bookclub.models.Category;
import com.stack_java.bookclub.models.Product;
import com.stack_java.bookclub.repositories.CategoryRepository;
import com.stack_java.bookclub.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product findById(Long productId) {
		Optional<Product> optional = productRepository.findById((Long) productId);
		return optional.get();
	}

	public List<Category> someCategories(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}

	public Product addCategory(Long productId, Long categoryId) {
		Category category = categoryRepository.findById(categoryId).get();
		Product product = productRepository.findById(productId).get();
		product.getCategories().add(category);
		productRepository.save(product);
		return product;
	}
}
