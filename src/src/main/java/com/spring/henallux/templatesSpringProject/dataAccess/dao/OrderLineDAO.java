package com.spring.henallux.templatesSpringProject.dataAccess.dao;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.model.Order;
import com.spring.henallux.templatesSpringProject.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineDAO {

    private OrderLineRepository orderLineRepository;

    @Autowired
    public OrderLineDAO(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    public OrderLine save(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = new ProviderConverter().orderLineModelToOrderLineEntity(orderLine);
        OrderLineEntity newOrderLineEntity = this.orderLineRepository.save(orderLineEntity);
        return new ProviderConverter().orderLineEntityToOrderLineModel(newOrderLineEntity);
    }
}
