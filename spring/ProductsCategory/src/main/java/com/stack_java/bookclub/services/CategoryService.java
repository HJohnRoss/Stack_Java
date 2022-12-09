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
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired ProductRepository productRepository;
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category getOne(Long id) {
		Optional<Category> optional = categoryRepository.findById((Long) id);
		if(optional != null) {			
			return optional.get();
		}
		return null;
	}

	public Category findById(Long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		return optional.get();
	}

	public Category addProduct(Long categoryId, Long productId) {
		Category category = categoryRepository.findById(categoryId).get();
		Product product = productRepository.findById(productId).get();
		category.getProducts().add(product);
		categoryRepository.save(category);
		return category;
	}
	
	public List<Product> someProducts(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
}
