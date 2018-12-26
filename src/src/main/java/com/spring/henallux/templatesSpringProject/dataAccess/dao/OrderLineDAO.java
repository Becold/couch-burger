package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderLineDAO {

    private OrderLineRepository orderLineRepository;

    public OrderLineDAO(OrderLineRepository orderLineRepository) { this.orderLineRepository = orderLineRepository; }
}
