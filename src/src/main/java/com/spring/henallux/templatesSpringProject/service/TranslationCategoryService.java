package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.dao.TranslationCategoryDAO;
import com.spring.henallux.templatesSpringProject.model.TranslationCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslationCategoryService {

    private TranslationCategoryDAO translationCategoryDAO;

    @Autowired
    public TranslationCategoryService(TranslationCategoryDAO translationCategoryDAO) {
        this.translationCategoryDAO = translationCategoryDAO;
    }

    public ArrayList<TranslationCategory> findByLanguageName(String langCode) {
        return this.translationCategoryDAO.findByLanguageName(langCode);
    }

    public TranslationCategory findByCategoryCategoryIdAndLanguageName(Integer categoryId, String langCode){
        return this.translationCategoryDAO.findByCategoryCategoryIdAndLanguageName(categoryId,langCode);
    }
}
