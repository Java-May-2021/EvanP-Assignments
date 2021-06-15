package com.evan.projectsAndCatagories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.projectsAndCatagories.models.Category;
import com.evan.projectsAndCatagories.models.Product;
import com.evan.projectsAndCatagories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	public List<Product> getAll() {
		return this.pRepo.findAll();
	}
	
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	public Product getSingleProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
//	public Product updateProduct(Product product) {
//		return this.pRepo.save(product);
//	}
	
	public List<Product> getProductsNotInCategory(Category category) {
		return this.pRepo.findByCategoriesNotContains(category);
	}

}
