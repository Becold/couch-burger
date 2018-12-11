package com.spring.henallux.templatesSpringProject.dataAccess.entity;


import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity(name = "Promotion")
public class PromotionEntity {
    @Id
    @Column(name = "promotionId")
    @GeneratedValue
    private Integer promotionId;

    @Column(name = "startDate")
    private GregorianCalendar startDate;

    @Column(name = "endDate")
    private GregorianCalendar endDate;

    @Column(name = "typeChoosenItem")
    private String typeChoosenItem;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name="productId")
    private ProductEntity product;

    @Column(name = "typeReduction")
    private String typeReduction;

    @Column(name = "amountReduction")
    private double amountReduction;

    public PromotionEntity() { }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    public String getTypeChoosenItem() {
        return typeChoosenItem;
    }

    public void setTypeChoosenItem(String typeChoosenItem) {
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

    public String getTypeReduction() {
        return typeReduction;
    }

    public void setTypeReduction(String typeReduction) {
        this.typeReduction = typeReduction;
    }

    public double getAmountReduction() {
        return amountReduction;
    }

    public void setAmountReduction(double amountReduction) {
        this.amountReduction = amountReduction;
    }
}
