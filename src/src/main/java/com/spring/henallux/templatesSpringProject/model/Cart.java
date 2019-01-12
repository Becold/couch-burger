package com.spring.henallux.templatesSpringProject.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private ArrayList<Product> products;
    private ArrayList<Promotion> promotions;

    public Cart() { }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(ArrayList<Promotion> promotions) {
        this.promotions = promotions;
    }
}
