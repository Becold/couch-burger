package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import com.spring.henallux.templatesSpringProject.model.Category;
import com.spring.henallux.templatesSpringProject.model.TranslationCategory;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TranslationCategoryEntity {
    @Column
    private Integer translationId;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "languageId")
    private LanguageEntity language;

    @Column
    private String content;

    public TranslationCategory() { }

    public Integer getTranslationId() {
        return translationId;
    }

    public void setTranslationId(Integer translationId) {
        this.translationId = translationId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
