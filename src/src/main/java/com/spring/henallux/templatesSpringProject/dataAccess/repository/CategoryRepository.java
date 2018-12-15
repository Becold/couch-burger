package com.spring.henallux.templatesSpringProject.dataAccess.repository;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.entity.TranslationCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    CategoryEntity findByCategoryId(Integer categoryId);
    CategoryEntity findByCategoryIdAndTranslations(Integer categoryId, String languageCode);
}
