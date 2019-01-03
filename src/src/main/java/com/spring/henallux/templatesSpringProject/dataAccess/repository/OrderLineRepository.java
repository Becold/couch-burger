package com.spring.henallux.templatesSpringProject.dataAccess.repository;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderEntity, Integer> {
}