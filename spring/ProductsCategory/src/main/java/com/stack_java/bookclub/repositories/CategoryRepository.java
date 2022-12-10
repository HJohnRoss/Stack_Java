package com.stack_java.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stack_java.bookclub.models.Category;
import com.stack_java.bookclub.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	
//	List<Category> findAllProducts(Product product);
	
	List<Category> findByProductsNotContains(Product product);
}
