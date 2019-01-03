package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "`order`")
public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name = "orderId")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private UserEntity user;

    @Column(name = "creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "isPaid")
    private Boolean isPaid;

    public OrderEntity() { }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}
