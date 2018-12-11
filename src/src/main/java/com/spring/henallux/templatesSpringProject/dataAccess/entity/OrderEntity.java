package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import com.spring.henallux.templatesSpringProject.model.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.GregorianCalendar;

public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "user_id")
    private User user;

    @Column(name = "creationDate")
    private GregorianCalendar creationDate;

    @Column(name = "isPaid")
    private Boolean isPaid;

    public OrderEntity() { }
}
