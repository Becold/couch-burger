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
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "creationDate")
    private GregorianCalendar creationDate;

    @Column(name = "isPaid")
    private Boolean isPaid;

    public OrderEntity() { }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(GregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}
