package com.spring.henallux.templatesSpringProject.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

public class Promotion {
    @NotNull
    private Integer promotionId;

    @NotNull
    private GregorianCalendar startDate;

    @NotNull
    private GregorianCalendar endDate;

    @NotBlank
    private String typeChoosenItem;

    private Category category;

    private Product product;

    @NotNull
    private String typeReduction;

    @NotNull
    private double amountReduction;

    public Promotion() {}

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    public String getTypeChoosenItem() {
        return typeChoosenItem;
    }

    public void setTypeChoosenItem(String typeChoosenItem) {
        this.typeChoosenItem = typeChoosenItem;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getTypeReduction() {
        return typeReduction;
    }

    public void setTypeReduction(String typeReduction) {
        this.typeReduction = typeReduction;
    }

    public double getAmountReduction() {
        return amountReduction;
    }

    public void setAmountReduction(double amountReduction) {
        this.amountReduction = amountReduction;
    }
}
