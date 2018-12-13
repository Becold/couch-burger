package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.templatesSpringProject.dataAccess.dao.ICategoryDAO;
import com.spring.henallux.templatesSpringProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public List<Category> findAll() {
        return this.categoryDAO.findAll();
    }

    public Category find(Integer categoryId) {
        return this.categoryDAO.find(categoryId);
    }
}
