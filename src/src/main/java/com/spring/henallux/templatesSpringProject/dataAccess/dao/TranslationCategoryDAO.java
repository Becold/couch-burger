package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.repository.TranslationCategoryRepository;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.model.TranslationCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslationCategoryDAO {

    private TranslationCategoryRepository translationCategoryRepository;

    @Autowired
    public TranslationCategoryDAO(TranslationCategoryRepository translationCategoryRepository) {
        this.translationCategoryRepository = translationCategoryRepository;
    }

    public List<TranslationCategory> findByLanguageName(String langCode) {
        List<TranslationCategory> categories = new ArrayList<>();
        List<TranslationCategoryEntity> categoriesEntity = this.translationCategoryRepository.findByLanguageName(langCode);
        for (TranslationCategoryEntity categoryEntity : categoriesEntity) {
            categories.add(new ProviderConverter().translationCategoryEntityToTranslationCategoryModel(categoryEntity));
        }
        return categories;
    }
    public TranslationCategory findByCategoryCategoryIdAndLanguageName(Integer categoryId, String langCode){
        return new ProviderConverter().translationCategoryEntityToTranslationCategoryModel(this.translationCategoryRepository.findByCategoryCategoryIdAndLanguageName(categoryId,langCode));
    }
}
