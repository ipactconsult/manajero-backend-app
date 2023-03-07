package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.Category;

public interface ICategoryBusiness {
	
	public List<Category> getAllCategories();
	public List<Category> getAllCategoriesASC();
	public List<Category> getAllCategoriesDESC();
        public List<Category> getAllCategoriesASCRef();
	public List<Category> getAllCategoriesDESCRef();
	public Category getOneCategory(String categoryId);
	public Category addNewCategory(Category category);
	public Category archiveCategory(String categoryId);
	public Category restoreCategory(String categoryId);

}
