package com.stack_java.bookclub.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stack_java.bookclub.models.Category;
import com.stack_java.bookclub.models.Product;
import com.stack_java.bookclub.services.CategoryService;
import com.stack_java.bookclub.services.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

//	Dashboard
	@GetMapping("/")
	public String dashboard(Model model) {
		model.addAttribute("allProducts", productService.allProducts());
		model.addAttribute("allCategories", categoryService.allCategories());
		return "index.jsp";
	}

//	========================= CATEGORY ========================
//	show create categories
	@GetMapping("/category/create")
	public String category(Model model) {
		model.addAttribute("category", new Category());
		return "createCategories.jsp";
	}

//	create category
	@PostMapping("/category/create/success")
	public String createCategory(@Valid @ModelAttribute("category") Category category, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("category", new Category());
			return "redirect:/category/create";
		}
		categoryService.createCategory(category);
		return "redirect:/";
	}

//	get one category
//	adding to many to many table
	@GetMapping("/category/show/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneCategory", categoryService.getOne(id));

		List<Product> someProducts = categoryService.someProducts(categoryService.getOne(id));
		model.addAttribute("someProducts", someProducts);
		return "oneCategory.jsp";
	}

//	creating many to many
	@PostMapping("/product/add/{id}")
	public String addProduct(@PathVariable("id") Long categoryId, @RequestParam(value = "product") Long productId,
			Model model) {
		categoryService.addProduct(categoryId, productId);
		return "redirect:/category/show/{id}";
	}

//	========================= PRODUCTS ========================
//	show create products
	@GetMapping("/product/create")
	public String product(Model model) {
		model.addAttribute("product", new Product());
		return "createProduct.jsp";
	}

	@PostMapping("/product/create/success")
	public String createProduct(@Valid @ModelAttribute("product") Product product, Model model, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("product", new Product());
			return "redirect:/product/create";
		}
		productService.createProduct(product);
		return "redirect:/";
	}

	@GetMapping("/product/show/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneProduct", productService.findById(id));

		List<Category> categories = productService.someCategories(productService.findById(id));
		model.addAttribute("someCategories", categories);
		return "oneProduct.jsp";
	}

	@PostMapping("/category/add/{id}")
	public String addCategory(@PathVariable("id") Long productId, @RequestParam(value = "categoryId") Long categoryId,
			Model model) {
		productService.addCategory(productId, categoryId);
		return "redirect:/product/show/{id}";
	}

}
