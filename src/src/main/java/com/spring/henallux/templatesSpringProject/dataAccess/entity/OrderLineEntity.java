package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity(name = "OrderLine")
public class OrderLineEntity {
    @Id
    @Column(name = "orderLineId")
    @GeneratedValue
    private Integer orderLineId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private ProductEntity product;

    @JoinColumn(name="orderId",referencedColumnName = "orderId")
    @ManyToOne
    private OrderEntity order;

    @Column(name = "unitPrice")
    private Double unitPrice;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderLineEntity() { }

    public Integer getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(Integer orderLineId) {
        this.orderLineId = orderLineId;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
