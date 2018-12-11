package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import com.spring.henallux.templatesSpringProject.model.User;

import javax.persistence.*;
import java.util.GregorianCalendar;

public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name = "orderId")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    @Column(name = "creationDate")
    private GregorianCalendar creationDate;

    @Column(name = "isPaid")
    private Boolean isPaid;

    public OrderEntity() { }
}
