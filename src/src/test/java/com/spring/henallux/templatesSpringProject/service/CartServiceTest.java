package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductCart;
import com.spring.henallux.templatesSpringProject.model.promotion.FinalAmountCart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CartServiceTest {

    private CartService cartService;

    @Before
    @Autowired
    public void setUp(CartService cartService) throws Exception {
        this.cartService = cartService;
    }

    @Test
    public void findBestPromotionForProductTest() {
        Product product = new Product();
        // TODO Faire tous les setters pour créer un faux produit

        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        // TODO Remplir la array list de fausse promotions

        Double reductionAmount = this.cartService.findBestPromotionForProduct(product, promotions);

        // TODO A la place de 5.01, mettre le montant de la reduction calculé ci-dessus
        // TODO 0.01 correspond, à changer peut-être
        Assert.assertEquals(5.01, reductionAmount, 0.01);
    }

    @Test
    public void getFinalAmountCartTest() {
        HashMap<Integer, ProductCart> cart = new HashMap<>();
        // TODO Remplir le carte de ProductCart (qui contient des quantités et des produits...
        // TODO Donc créer des produits avant ça

        FinalAmountCart finalAmountCart = this.cartService.getFinalAmountCart(cart);

        // TODO A la place de 5.01, mettre le montant de la reduction calculé ci-dessus
        // TODO 0.01 correspond, à changer peut-être
        Assert.assertEquals(5.01, finalAmountCart.getTotal(), 0.01);
        Assert.assertEquals(5.01, finalAmountCart.getReduction(), 0.01);
    }
}