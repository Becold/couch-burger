package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue
    @Column(name = "categoryId")
    private Integer categoryId;

    public CategoryEntity() { }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
