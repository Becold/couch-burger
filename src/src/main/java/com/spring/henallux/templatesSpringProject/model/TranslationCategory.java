package com.spring.henallux.templatesSpringProject.model;

import javax.validation.constraints.NotNull;

public class TranslationCategory {
    @NotNull
    private Integer translationId;

    @NotNull
    private Category category;

    @NotNull
    private Language language;

    @NotNull
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
