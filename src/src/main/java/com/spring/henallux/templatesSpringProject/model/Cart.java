package com.spring.henallux.templatesSpringProject.model;

import java.util.List;

public class Cart {
    private List<Product> products;
    private List<Promotion> promotions;

    public Cart() { }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}
