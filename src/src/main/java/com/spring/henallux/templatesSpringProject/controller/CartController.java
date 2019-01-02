package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.exception.ProductNotFoundException;
import com.spring.henallux.templatesSpringProject.exception.QuantityIsNegativeException;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductForm;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductCart;
import com.spring.henallux.templatesSpringProject.service.CartService;
import com.spring.henallux.templatesSpringProject.service.ProductService;
import com.spring.henallux.templatesSpringProject.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@SessionAttributes({Constants.CART})
public class CartController {

    private ProductService productService;
    private CartService cartService;
    private PromotionService promotionService;

    @ModelAttribute(Constants.CART)
    public HashMap<Integer, ProductCart> cart() {
        return new HashMap<>();
    }

    @Autowired
    public CartController(ProductService productService,
                          CartService cartService,
                          PromotionService promotionService) {
        this.productService = productService;
        this.cartService = cartService;
        this.promotionService = promotionService;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(Model model,
                          @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm,
                          @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart) {
        List<Promotion> promotions = new ArrayList<Promotion>(); // TODO Récupérer les promotions qui s'appliquent au panier
        model.addAttribute("title", "Mon panier");
        model.addAttribute("totalPrice", this.cartService.getFormattedTotalPrice(cart, promotions));
        return "integrated:cart";
    }

    @RequestMapping(value = "/cart/addProduct",
                    method = RequestMethod.POST)
    public String postAddProduct(Model model,
                                 @Valid @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm,
                                 @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart,
                                 BindingResult errors) {
        try {
            Integer productId = productForm.getProductId();
            Integer quantity = productForm.getQuantity();
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
        } catch (QuantityIsNegativeException e) {
            // TODO: Afficher "La quantité ne peut être négatif."
            model.addAttribute("errorMessage", "");
            return "integrated:keyError";
        }
    }

    @RequestMapping(value = "/cart/removeProduct",
                    method = RequestMethod.POST)
    public String postRemoveProduct(Model model,
                                    @Valid @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm,
                                    @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart,
                                    BindingResult errors) {
        try {
            Integer productId = productForm.getProductId();
            Integer quantity = productForm.getQuantity();

            if (cart.containsKey(productId)) {
                if (cart.get(productId).getQuantity() <= quantity) {
                    cart.remove(productId);
                } else {
                    cart.get(productId).removeQuantity(quantity);
                }
            }
            return "redirect:/cart";
        }
        catch (QuantityIsNegativeException exception) {
            // TODO Afficher "Erreur: La quantité ne peut être négatif."
            return "integrated:keyError";
        }
    }

    @RequestMapping(value = "/cart/setProduct",
                    method = RequestMethod.POST)
    public String postSetProduct(Model model,
                                    @Valid @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm,
                                    @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart,
                                    BindingResult errors) {
        try {
            Integer productId = productForm.getProductId();
            Integer quantity = productForm.getQuantity();
            Product product = productService.findOne(productId);

            if (cart.containsKey(productId)) {
                cart.get(productId).setQuantity(quantity);
            }
            else {
                ProductCart productCart = new ProductCart();
                productCart.setProduct(product);
                productCart.setQuantity(quantity);
                cart.put(productId, productCart);
            }
            return "redirect:/cart";
        }
        catch (QuantityIsNegativeException exception) {
            // TODO Afficher "Erreur: La quantité ne peut être négatif."
            return "integrated:keyError";
        }
        catch (ProductNotFoundException e) {
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
