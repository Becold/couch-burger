package com.spring.henallux.templatesSpringProject.dataAccess.entity;


import com.spring.henallux.templatesSpringProject.model.promotion.TypeChoosenItem;
import com.spring.henallux.templatesSpringProject.model.promotion.TypeReduction;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity(name = "promotion")
public class PromotionEntity {
    @Id
    @Column(name = "promotionId")
    @GeneratedValue
    private Integer promotionId;

    @Column(name = "startDate", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "endDate", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "typeChoosenItem")
    private TypeChoosenItem typeChoosenItem;

    @ManyToOne
    @JoinColumn(name="categoryId",referencedColumnName = "categoryId")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name="productId",referencedColumnName = "productId")
    private ProductEntity product;

    @Column(name = "typeReduction")
    private TypeReduction typeReduction;

    @Column(name = "amountReduction")
    private Double amountReduction;

    public PromotionEntity() { }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TypeChoosenItem getTypeChoosenItem() {
        return typeChoosenItem;
    }

    public void setTypeChoosenItem(TypeChoosenItem typeChoosenItem) {
        this.typeChoosenItem = typeChoosenItem;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public TypeReduction getTypeReduction() {
        return typeReduction;
    }

    public void setTypeReduction(TypeReduction typeReduction) {
        this.typeReduction = typeReduction;
    }

    public double getAmountReduction() {
        return amountReduction;
    }

    public void setAmountReduction(double amountReduction) {
        this.amountReduction = amountReduction;
    }
}
