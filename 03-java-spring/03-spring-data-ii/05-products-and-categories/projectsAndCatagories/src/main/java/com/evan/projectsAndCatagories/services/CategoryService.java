package com.evan.projectsAndCatagories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.projectsAndCatagories.models.Category;
import com.evan.projectsAndCatagories.models.Product;
import com.evan.projectsAndCatagories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	public List<Category> getAll(){
		return this.cRepo.findAll();
	}
	
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	public Category getSingleCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public List<Category> getCategoriesNotInProducts(Product product) {
		return this.cRepo.findByProductsNotContains(product);
	}

}
