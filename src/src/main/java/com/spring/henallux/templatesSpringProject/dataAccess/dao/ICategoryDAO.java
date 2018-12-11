package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.model.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> findAll();
}
