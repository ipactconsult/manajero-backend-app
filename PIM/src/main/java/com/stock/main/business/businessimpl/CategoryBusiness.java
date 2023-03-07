package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.ICategoryBusiness;
import com.stock.main.entities.Category;
import com.stock.main.repositories.CategoryRepository;

@Service
public class CategoryBusiness implements ICategoryBusiness {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
        @Override
	public List<Category> getAllCategories() {
		List<Category> categories = categoryRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "categoryCreationDate")
                );
		if (!categories.isEmpty()) {
			return categories;
		} else {
			return new ArrayList<>();
		}
	}
	
        @Override
	public List<Category> getAllCategoriesASC() {
		List<Category> categories = categoryRepo.findAll(
				Sort.by(Sort.Direction.ASC, "categoryName"));
		if (!categories.isEmpty()) {
			return categories;
		} else {
			return new ArrayList<>();
		}
	}
	
        @Override
	public List<Category> getAllCategoriesDESC() {
		List<Category> categories = categoryRepo.findAll(
				Sort.by(Sort.Direction.DESC, "categoryName"));
		if (!categories.isEmpty()) {
			return categories;
		} else {
			return new ArrayList<>();
		}
	}
        
        @Override
	public List<Category> getAllCategoriesASCRef() {
		List<Category> categories = categoryRepo.findAll(
				Sort.by(Sort.Direction.ASC, "categoryCode"));
		if (!categories.isEmpty()) {
			return categories;
		} else {
			return new ArrayList<>();
		}
	}
	
        @Override
	public List<Category> getAllCategoriesDESCRef() {
		List<Category> categories = categoryRepo.findAll(
				Sort.by(Sort.Direction.DESC, "categoryCode"));
		if (!categories.isEmpty()) {
			return categories;
		} else {
			return new ArrayList<>();
		}
	}
	
        @Override
	public Category getOneCategory(String categoryId) {
				Category existedCategory = categoryRepo.findById(categoryId).orElse(null);
				if (existedCategory != null) {
					return existedCategory;
				} else {
					return null;
				}
	}
	
        @Override
	public Category addNewCategory(Category category) {
			category.setCategoryCreationDate(new Date());
			category.setCategoryState(true);
			int existNumber = 0;
			List<Category> categories = categoryRepo.findAll();
			if (!categories.isEmpty()) {
				for (int m = 0; m < categories.size(); m++) {
					if (categories.get(m).getCategoryName().equals(category.getCategoryName())
                                            && categories.get(m).getAddedBy().equals(category.getAddedBy())) {
						existNumber = existNumber + 1;
					}
				}
			}
			if (existNumber == 0) {
				categoryRepo.save(category);
				return category;
			} else {
				return null;
			}
	}
	
        @Override
	public Category archiveCategory(String categoryId) {
		Category existedCategory = categoryRepo.findById(categoryId).orElse(null);
				if (existedCategory != null) {
					existedCategory.setCategoryState(false);
					categoryRepo.save(existedCategory);
					return existedCategory;
				} else {
					return null;
				}
	}
	
        @Override
	public Category restoreCategory(String categoryId) {
		Category existedCategory = categoryRepo.findById(categoryId).orElse(null);
				if (existedCategory != null) {
					existedCategory.setCategoryState(true);
					categoryRepo.save(existedCategory);
					return existedCategory;
				} else {
					return null;
				}
	}

}
