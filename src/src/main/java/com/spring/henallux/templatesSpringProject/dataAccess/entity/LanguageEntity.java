package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity(name = "language")
public class LanguageEntity {
    @Id
    @Column(name = "languageId")
    @GeneratedValue
    private Integer languageId;

    @Column(name = "name")
    private String name;

    public LanguageEntity() { }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
