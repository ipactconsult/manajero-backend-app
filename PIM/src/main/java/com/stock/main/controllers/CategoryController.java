package com.stock.main.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.main.business.businessimpl.CategoryBusiness;
import com.stock.main.business.dtos.CategoryDTO;
import com.stock.main.entities.Category;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class CategoryController {
	
	@Autowired
	private CategoryBusiness categoryBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<Category> getAllCategories() {
		return categoryBusiness.getAllCategories();
	}
	
	@GetMapping("/all/asc")
	public List<Category> getAllCategoriesASC() {
		return categoryBusiness.getAllCategoriesASC();
	}
	
	@GetMapping("/all/desc")
	public List<Category> getAllCategoriesDESC() {
		return categoryBusiness.getAllCategoriesDESC();
	}
        
        @GetMapping("/all/ref/asc")
	public List<Category> getAllCategoriesASCRef() {
		return categoryBusiness.getAllCategoriesASCRef();
	}
	
	@GetMapping("/all/ref/desc")
	public List<Category> getAllCategoriesDESCRef() {
		return categoryBusiness.getAllCategoriesDESCRef();
	}
	
	@GetMapping("/show/{categoryId}")
	public Category getOneCategory(@PathVariable String categoryId) {
		return categoryBusiness.getOneCategory(categoryId);
	}
	
	@PostMapping("/create")
	public Category addNewCategory(@RequestBody CategoryDTO categoryDTO) {
		Category category = convertToEntity(categoryDTO);
		return categoryBusiness.addNewCategory(category);
	}
	
	@PutMapping("/archive/{categoryId}")
	public Category archiveCategory(@PathVariable String categoryId) {
		return categoryBusiness.archiveCategory(categoryId);
	}
	
	@PutMapping("/restore/{categoryId}")
	public Category restoreCategory(@PathVariable String categoryId) {
		return categoryBusiness.restoreCategory(categoryId);
	}
	
	private Category convertToEntity(CategoryDTO categoryDTO) {
	    return modelMapper.map(categoryDTO, Category.class);
	}

}
