package com.stack_java.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stack_java.bookclub.models.Category;
import com.stack_java.bookclub.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();

//	List<Product> findAllByCategories(Category category);

	List<Product> findByCategoriesNotContains(Category category);
}
