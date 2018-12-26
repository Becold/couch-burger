package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.dao.OrderLineDAO;
import com.spring.henallux.templatesSpringProject.dataAccess.dao.PromotionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {

    private OrderLineDAO orderLineDAO;

    @Autowired
    public OrderLineService(OrderLineDAO orderLineDAO){this.orderLineDAO=orderLineDAO;}
}
