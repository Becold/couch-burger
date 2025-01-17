package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import com.spring.henallux.templatesSpringProject.model.Product;

import javax.persistence.*;
import java.util.ArrayList;

@Entity(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "productId")
    @GeneratedValue
    private Integer productId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId")
    private CategoryEntity category;

    @Column(name = "unitPrice")
    private Double unitPrice;

    @Column(name = "vatRate")
    private Double vatRate;

    @Column(name = "type")
    private String type;

    @Column(name = "isSparkling")
    private Boolean isSparkling;

    @Column(name = "isSpicy")
    private Boolean isSpicy;

    @Column(name = "isSweet")
    private Boolean isSweet;

    public ProductEntity() { }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getVatRate() {
        return vatRate;
    }

    public void setVatRate(Double vatRate) {
        this.vatRate = vatRate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsSparkling() {
        return isSparkling;
    }

    public void setIsSparkling(Boolean sparkling) {
        isSparkling = sparkling;
    }

    public Boolean getIsSpicy() {
        return isSpicy;
    }

    public void setIsSpicy(Boolean spicy) {
        isSpicy = spicy;
    }

    public Boolean getIsSweet() {
        return isSweet;
    }

    public void setIsSweet(Boolean sweet) {
        isSweet = sweet;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void setSparkling(Boolean sparkling) { isSparkling = sparkling; }
}
