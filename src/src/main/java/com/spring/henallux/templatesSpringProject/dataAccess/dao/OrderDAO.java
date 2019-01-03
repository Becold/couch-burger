package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDAO {

    private OrderRepository orderRepository;

    @Autowired
    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(OrderEntity orderEntity) {
        OrderEntity orderEntitySaved = this.orderRepository.save(orderEntity);
        return new ProviderConverter().orderEntityToOrderModel(orderEntitySaved);
    }
}
