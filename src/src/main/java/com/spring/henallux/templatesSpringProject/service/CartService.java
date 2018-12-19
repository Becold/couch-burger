package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductCart;
import org.apache.tiles.request.collection.MapEntry;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    public CartService() { }

    public Double getTotalPrice(HashMap<Integer, ProductCart> cart, List<Promotion> promotions) {
        Double totalPrice = 0.00;
        for (Map.Entry<Integer, ProductCart> entry : cart.entrySet()) {
            totalPrice += entry.getValue().getProduct().getUnitPriceWithVat() * entry.getValue().getQuantity();
        }
        return totalPrice;
    }

    public String getFormattedTotalPrice(HashMap<Integer, ProductCart> cart, List<Promotion> promotions) {
        return String.format("%.2f", this.getTotalPrice(cart, promotions));
    }
}
