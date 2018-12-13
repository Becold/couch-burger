package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
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

    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        List<CategoryEntity> categoriesEntity = this.categoryRepository.findAll();
        for (CategoryEntity categoryEntity : categoriesEntity) {
            Category category = new ProviderConverter().categoryEntityToCategoryModel(categoryEntity); // TODO category model to category entity
            categories.add(category);
        }
        return categories;
    }

    public Category find(Integer categoryId) {
        CategoryEntity categoryEntity = this.categoryRepository.findByCategoryId(categoryId);
        if (categoryEntity != null) {
            Category category = new ProviderConverter().categoryEntityToCategoryModel(categoryEntity);
            return category;
        }
        return null;
    }
}
