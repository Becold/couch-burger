package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity(name = "OrderLine")
public class OrderLineEntity {
    @Id
    @Column(name = "orderLineId")
    @GeneratedValue
    private Integer orderLineId;

    @ManyToOne
    @JoinColumn(name="orderId")
    private OrderEntity order;

    @Column(name = "unitPrice")
    private double unitPrice;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderLineEntity() { }

    public Integer getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(Integer orderLineId) {
        this.orderLineId = orderLineId;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
