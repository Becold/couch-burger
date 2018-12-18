package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.repository.TranslationCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslationCategoryDAO {

    private TranslationCategoryRepository translationCategoryRepository;

    @Autowired
    public TranslationCategoryDAO(TranslationCategoryRepository translationCategoryRepository) {
        this.translationCategoryRepository = translationCategoryRepository;
    }


}
