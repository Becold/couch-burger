package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.dao.OrderLineDAO;
import com.spring.henallux.templatesSpringProject.dataAccess.dao.PromotionDAO;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.model.OrderLine;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineService {

    private OrderLineDAO orderLineDAO;
    private ProductService productService;

    @Autowired
    public OrderLineService(OrderLineDAO orderLineDAO,
                            ProductService productService) {
        this.orderLineDAO = orderLineDAO;
        this.productService = productService;
    }

    public OrderLine save(OrderLine orderLine) {
        return this.orderLineDAO.save(orderLine);
    }

    public Double getPrice(Integer quantity, Product product) {
        return product.getUnitPriceWithVat() * (double)quantity;
    }
}
