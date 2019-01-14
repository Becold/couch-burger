package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.exception.UnknowTypeReductionException;
import com.spring.henallux.templatesSpringProject.model.Category;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.model.promotion.TypeChoosenItem;
import com.spring.henallux.templatesSpringProject.model.promotion.TypeReduction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.GregorianCalendar;

@RunWith(SpringJUnit4ClassRunner.class)
public class CartServiceTest {

    public static Product product;
    public static Category category;
    public static Category categoryFalse;
    public static Product productFalse;

    @Mock
    public static CartService cartService;

    @BeforeClass
    public static void setUp() throws Exception {
        category = new Category();
        category.setCategoryId(1);

        categoryFalse = new Category();
        categoryFalse.setCategoryId(2);

        product = new Product();
        product.setProductId(1);
        product.setCategory(category);
        product.setUnitPrice(10.00);
        product.setVatRate(12.00);
        product.setType("Burger");
        product.setIsSpicy(false);
        product.setIsSweet(true);
        product.setName("ChickenTestBurger");

        productFalse = new Product();
        productFalse.setProductId(2);
        productFalse.setCategory(categoryFalse);
        productFalse.setUnitPrice(15.00);
        productFalse.setVatRate(12.00);
        productFalse.setType("Burger");
        productFalse.setIsSpicy(true);
        productFalse.setIsSweet(true);
        productFalse.setName("BeefTestBurger");
    }

    @Test
    public void findBestPromotionForProductTest1() {
        ArrayList<Promotion> promotions = new ArrayList<>();
        // Ok
        promotions.add(new Promotion(1,new GregorianCalendar(2018,12,1),new GregorianCalendar(2019,2,1), TypeChoosenItem.CATEGORY,category,null,TypeReduction.FIXE,2.00));
        promotions.add(new Promotion(2,new GregorianCalendar(2019,1,1),new GregorianCalendar(2019,3,1), TypeChoosenItem.PRODUCT,null,product,TypeReduction.POURCENTAGE,0.5));

        Double reductionAmount = null;
        try {
            reductionAmount = cartService.findBestPromotionForProduct(product, promotions);
        } catch (UnknowTypeReductionException e) { }

        Assert.assertEquals(0.00, reductionAmount, 0.01);
    }

    @Test
    public void findBestPromotionForProductTest2() {
        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
         //Périmée
        promotions.add(new Promotion(1,new GregorianCalendar(2018,12,1),new GregorianCalendar(2019,1,1), TypeChoosenItem.CATEGORY,category,null,TypeReduction.FIXE,1000.00));

        Double reductionAmount = null;
        try {
            reductionAmount = cartService.findBestPromotionForProduct(product, promotions);
        } catch (UnknowTypeReductionException e) { }


        Assert.assertEquals(0.00, reductionAmount, 0.01);
    }

    @Test
    public void findBestPromotionForProductTest3() {
        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        //Pas encore active
        promotions.add(new Promotion(1,new GregorianCalendar(2019,12,1),new GregorianCalendar(2019,12,5), TypeChoosenItem.CATEGORY,category,null,TypeReduction.FIXE,1000.00));

        Double reductionAmount = null;
        try {
            reductionAmount = cartService.findBestPromotionForProduct(product, promotions);
        } catch (UnknowTypeReductionException e) { }

        Assert.assertEquals(0.00, reductionAmount, 0.01);
    }

    @Test
    public void findBestPromotionForProductTest4() {
        ArrayList<Promotion> promotions = new ArrayList<Promotion>();
        //Pas correspondante
        promotions.add(new Promotion(1,new GregorianCalendar(2018,12,1),new GregorianCalendar(2019,2,1), TypeChoosenItem.CATEGORY,categoryFalse,null,TypeReduction.FIXE,10000.00));
        promotions.add(new Promotion(2,new GregorianCalendar(2018,12,1),new GregorianCalendar(2019,2,1), TypeChoosenItem.PRODUCT,null,productFalse,TypeReduction.POURCENTAGE,0.90));

        Double reductionAmount = null;
        try {
            reductionAmount = cartService.findBestPromotionForProduct(product, promotions);
        } catch (UnknowTypeReductionException e) { }


        Assert.assertEquals(0.00, reductionAmount, 0.01);
    }
}