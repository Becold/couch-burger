package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.exception.CategoryNotFoundException;
import com.spring.henallux.templatesSpringProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ArrayList<Category> findAll() {
        ArrayList<Category> categories = new ArrayList<>();
        ArrayList<CategoryEntity> categoriesEntity = (ArrayList<CategoryEntity>) this.categoryRepository.findAll();
        for (CategoryEntity categoryEntity : categoriesEntity) {
            Category category = new ProviderConverter().categoryEntityToCategoryModel(categoryEntity);
            categories.add(category);
        }
        return categories;
    }

    public Category find(Integer categoryId) throws CategoryNotFoundException {
        CategoryEntity categoryEntity = this.categoryRepository.findByCategoryId(categoryId);
        if (categoryEntity == null) {
            throw new CategoryNotFoundException();
        }
        return new ProviderConverter().categoryEntityToCategoryModel(categoryEntity);
    }
}
