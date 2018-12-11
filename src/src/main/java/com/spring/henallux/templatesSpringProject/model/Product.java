package com.spring.henallux.templatesSpringProject.model;

public class Product {
    private Integer productId;
    private Category category;
    private Double unitPrice;
    private Double vatRate;
    private Integer type;
    private Boolean isSparkling;
    private Boolean isSpicy;
    private Boolean isSweet;

    public Product() { }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getSparkling() {
        return isSparkling;
    }

    public void setSparkling(Boolean sparkling) {
        isSparkling = sparkling;
    }

    public Boolean getSpicy() {
        return isSpicy;
    }

    public void setSpicy(Boolean spicy) {
        isSpicy = spicy;
    }

    public Boolean getSweet() {
        return isSweet;
    }

    public void setSweet(Boolean sweet) {
        isSweet = sweet;
    }
}