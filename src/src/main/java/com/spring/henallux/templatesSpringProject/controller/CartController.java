package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.exception.ProductNotFoundException;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.form.cart.AddProductForm;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductCart;
import com.spring.henallux.templatesSpringProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@SessionAttributes({Constants.CART})
public class CartController {

    private ProductService productService;

    @ModelAttribute(Constants.CART)
    public HashMap<Integer, ProductCart> cart() {
        return new HashMap<>();
    }

    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(Model model,
                          @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart) {
        model.addAttribute("title", "Mon panier");
        return "integrated:cart";
    }

    @RequestMapping(value = "/cart/addProduct",
                    method = RequestMethod.POST)
    public String postAddProduct(Model model,
                                 @Valid @ModelAttribute(Constants.ADD_PRODUCT_TO_CART_FORM)AddProductForm addProductForm,
                                 @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart,
                                 BindingResult errors) {
        try {
            Integer productId = addProductForm.getProductId();
            Integer quantity = addProductForm.getQuantity();
            Product product = this.productService.findOne(productId);

            if (cart.containsKey(productId)) {
                cart.get(productId).addQuantity(quantity);
            } else {
                ProductCart productCart = new ProductCart();
                productCart.setProduct(product);
                productCart.setQuantity(quantity);
                cart.put(productId, productCart);
            }
            return "redirect:/cart";
        }
        catch (ProductNotFoundException exception) {
            // TODO: Afficher "Ce produit n'existe pas."
            model.addAttribute("errorMessage", "");
            return "integrated:keyError";
        }
    }

    @RequestMapping(value = "/cart/confirmCart", method = RequestMethod.POST)
    public String postCartConfirm(Model model,
                                  @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart,
                                  BindingResult errors) {
        // TODO Vérifier le panier (que les produits existent toujours, que les quantités soient positifs, etc)
        // TODO Calcul des Promotions et du prix final
        // TODO Afficher le formulaire de paiement Paypal
        return "integrated:cart.paypal";
    }

    @RequestMapping(value = "/cart/confirmPaiement", method = RequestMethod.POST)
    public String postCartPaiement(Model model,
                                  @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart,
                                  BindingResult errors) {
        // TODO Vérifier le panier (que les produits existent toujours, que les quantités soient positifs, etc)
        // TODO Vérification paiement paypal
        // TODO Si paiement réussi: Enregistrer en DB le panier + message de réussite + vider la session
        // TODO Si paiement refusé: Afficher un message d'erreur
        return "integrated:cart.paypal";
    }
}
