package com.spring.henallux.templatesSpringProject.model.form.cart;

import com.spring.henallux.templatesSpringProject.model.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductCart {
    @NotNull
    private Product product;

    @Min(0)
    private Integer quantity;

    public ProductCart() {}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
    }
}
