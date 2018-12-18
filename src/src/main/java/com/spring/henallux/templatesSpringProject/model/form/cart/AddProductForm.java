package com.spring.henallux.templatesSpringProject.model.form.cart;

import com.spring.henallux.templatesSpringProject.model.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddProductForm {
    @NotNull
    private Integer productId;

    @Min(0)
    private Integer quantity;

    public AddProductForm() {}

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
