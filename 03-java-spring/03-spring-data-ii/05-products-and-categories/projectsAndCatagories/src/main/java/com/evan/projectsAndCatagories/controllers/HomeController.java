package com.evan.projectsAndCatagories.controllers;

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

import com.evan.projectsAndCatagories.models.Category;
import com.evan.projectsAndCatagories.models.Product;
import com.evan.projectsAndCatagories.services.CategoryService;
import com.evan.projectsAndCatagories.services.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService pService;
	@Autowired
	private CategoryService cService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newproduct.jsp";
	}
	
	@PostMapping(value="/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newproduct.jsp";
		}else {
			this.pService.createProduct(product);
			return "redirect:/products/" + product.getId();
		}
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@ModelAttribute("category") Category category, @PathVariable("id") Long id, Model model) {
		Product newProduct = pService.getSingleProduct(id);
		model.addAttribute("product", newProduct);
		List<Category> allCategories = this.cService.getCategoriesNotInProducts(newProduct);
		model.addAttribute("categories", allCategories);
		return "productpage.jsp";		
	}
	
	@PostMapping(value="/products/{id}")
	public String addCategoryToProduct(@PathVariable("id") Long productID, @RequestParam("category") Long categoryId) {
		Product product = pService.getSingleProduct(productID);
		Category category = cService.getSingleCategory(categoryId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		product.setCategories(categories);
		pService.createProduct(product);
		return "redirect:/products/" + product.getId();
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newcategory.jsp";
	}
	
	@PostMapping(value="/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newcategory.jsp";
		}else {
			this.cService.createCategory(category);
			return "redirect:/categories/" + category.getId();
		}
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@ModelAttribute("products") Product product, @PathVariable("id") Long id, Model model) {
		Category newCategory = cService.getSingleCategory(id);
		model.addAttribute("category", newCategory);
		List<Product> allProducts = this.pService.getProductsNotInCategory(newCategory);
		model.addAttribute("products", allProducts);
		return "categorypage.jsp";		
	}
	
	@PostMapping(value="/categories/{id}")
	public String addProductsToCategory(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {
		Category category = cService.getSingleCategory(categoryId);
		Product product = pService.getSingleProduct(productId);
		List<Product> products = category.getProducts();
		products.add(product);
		category.setProducts(products);
		cService.createCategory(category);
		return "redirect:/categories/" + category.getId();
	}

}
