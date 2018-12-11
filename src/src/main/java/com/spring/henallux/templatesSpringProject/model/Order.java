package com.spring.henallux.templatesSpringProject.model;

import javax.validation.constraints.NotNull;
import java.util.GregorianCalendar;

public class Order {
    @NotNull
    private Integer orderId;

    @NotNull
    private User user;

    @NotNull
    private GregorianCalendar creationDate;

    @NotNull
    private Boolean isPaid;

    public Order() { }

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
