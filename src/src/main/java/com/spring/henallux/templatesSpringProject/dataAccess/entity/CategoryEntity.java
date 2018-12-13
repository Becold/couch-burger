package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue
    @Column(name = "categoryId")
    private Integer categoryId;

    @OneToMany(mappedBy = "category")
    private List<TranslationCategoryEntity> translations;

    public CategoryEntity() { }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
