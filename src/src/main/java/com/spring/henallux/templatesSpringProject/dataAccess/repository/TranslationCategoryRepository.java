package com.spring.henallux.templatesSpringProject.dataAccess.repository;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.templatesSpringProject.model.TranslationCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface TranslationCategoryRepository extends JpaRepository<TranslationCategoryEntity, Integer> {
    ArrayList<TranslationCategoryEntity> findByLanguageName(String langCode);
    TranslationCategoryEntity findByCategoryCategoryIdAndLanguageName(Integer categoryId,String langCode);
}
