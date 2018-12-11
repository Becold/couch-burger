package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import com.spring.henallux.templatesSpringProject.model.Category;
import com.spring.henallux.templatesSpringProject.model.TranslationCategory;

import javax.persistence.*;

@Entity(name = "translationcategory")
public class TranslationCategoryEntity {
    @Column
    @Id
    @GeneratedValue
    private Integer translationId;

    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "languageId",referencedColumnName = "languageId")
    private LanguageEntity language;

    @Column
    private String content;

    public TranslationCategoryEntity() { }

    public Integer getTranslationId() {
        return translationId;
    }

    public void setTranslationId(Integer translationId) {
        this.translationId = translationId;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
