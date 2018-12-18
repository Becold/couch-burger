package com.spring.henallux.templatesSpringProject.dataAccess.repository;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.entity.TranslationCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TranslationCategoryRepository extends JpaRepository<TranslationCategoryEntity, Integer> {
    // List<CategoryEntity> TranslationCategoryByLanguage(String langCode);
}
