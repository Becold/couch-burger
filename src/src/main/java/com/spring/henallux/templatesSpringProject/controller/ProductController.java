package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.exception.ProductNotFoundException;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductForm;
import com.spring.henallux.templatesSpringProject.service.ProductService;
import com.spring.henallux.templatesSpringProject.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

@Controller
public class ProductController {

    private ProductService productService;
    private PromotionService promotionService;
    private MessageSource messageSource;

    @Autowired
    public ProductController(ProductService productService,
                             PromotionService promotionService,
                             MessageSource messageSource) {
        this.productService = productService;
        this.promotionService = promotionService;
        this.messageSource = messageSource;
    }

    @RequestMapping(value = "/product/{productId}",
                    method = RequestMethod.GET)
    public String getProduct(Model model,
                             Locale locale,
                             @PathVariable ("productId") Integer productId,
                             @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm) {
        try {
            GregorianCalendar currentDate = new GregorianCalendar();

            Product product = productService.findOne(productId);
            List<Promotion> currentPromotions = promotionService.findCurrentPromotions(
                    currentDate,
                    productId,
                    product.getCategory().getCategoryId()
            );

            model.addAttribute("product", product);
            model.addAttribute("promotions", currentPromotions);
            model.addAttribute("title",  messageSource.getMessage("title.articles",null,locale));
            return "integrated:product";
        }
        catch (ProductNotFoundException exception) {
            // TODO Afficher "Produit non trouvé"
            return "integrated:keyError";
        }
    }
}
