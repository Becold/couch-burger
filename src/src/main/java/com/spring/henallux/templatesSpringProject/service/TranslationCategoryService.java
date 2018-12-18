package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.dao.TranslationCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationCategoryService {

    private TranslationCategoryDAO translationCategoryDAO;

    @Autowired
    public TranslationCategoryService(TranslationCategoryDAO translationCategoryDAO) {
        this.translationCategoryDAO = translationCategoryDAO;
    }
}
