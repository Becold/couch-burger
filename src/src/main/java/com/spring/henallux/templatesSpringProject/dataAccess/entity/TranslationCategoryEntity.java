package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import com.spring.henallux.templatesSpringProject.model.Category;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TranslationCategoryEntity {
    @Column
    private Integer translationId;

    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "languageId",referencedColumnName = "languageId")
    private LanguageEntity language;

    @Column
    private String content;
}
