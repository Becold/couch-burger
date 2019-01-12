package com.spring.henallux.templatesSpringProject.model.promotion;

public class FinalAmountCart {
    private Double reduction;
    private Double total;

    public FinalAmountCart() {
        this.reduction = 0.00;
        this.total = 0.00;
    }

    public Double getReduction() {
        return reduction;
    }

    public void setReduction(Double reduction) {
        this.reduction = reduction;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
