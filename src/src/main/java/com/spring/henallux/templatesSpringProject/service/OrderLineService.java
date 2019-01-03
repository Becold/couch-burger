package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.dao.OrderLineDAO;
import com.spring.henallux.templatesSpringProject.dataAccess.dao.PromotionDAO;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;

@Service
public class OrderLineService {

    private OrderLineDAO orderLineDAO;

    @Autowired
    public OrderLineService(OrderLineDAO orderLineDAO){
        this.orderLineDAO = orderLineDAO;
    }

    public OrderLine save(OrderLine orderLine) {
        return this.orderLineDAO.save(orderLine);
    }
}
