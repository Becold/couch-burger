package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.exception.ProductNotFoundException;
import com.spring.henallux.templatesSpringProject.exception.QuantityIsNegativeException;
import com.spring.henallux.templatesSpringProject.exception.UnknowTypeReductionException;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductForm;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductCart;
import com.spring.henallux.templatesSpringProject.model.promotion.FinalAmountCart;
import com.spring.henallux.templatesSpringProject.model.promotion.TypeReduction;
import com.spring.henallux.templatesSpringProject.service.CartService;
import com.spring.henallux.templatesSpringProject.service.ProductService;
import com.spring.henallux.templatesSpringProject.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@SessionAttributes({Constants.CART})
public class CartController {

    private ProductService productService;
    private CartService cartService;
    private MessageSource messageSource;

    @ModelAttribute(Constants.CART)
    public HashMap<Integer, ProductCart> cart() {
        return new HashMap<>();
    }

    @Autowired
    public CartController(ProductService productService,
                          CartService cartService,
                          MessageSource messageSource) {
        this.productService = productService;
        this.cartService = cartService;
        this.messageSource = messageSource;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(Model model,
                          Locale locale,
                          @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm,
                          @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart) {
        try {
            FinalAmountCart finalAmountCart = this.cartService.getFinalAmountCart(cart);

            model.addAttribute("title", messageSource.getMessage("menu.cart", null, locale));
            model.addAttribute("totalAmountReduction", finalAmountCart.getReduction());
            model.addAttribute("totalAmountReductionFormatted", String.format("%.2f", finalAmountCart.getReduction()));
            model.addAttribute("totalPrice", String.format("%.2f", finalAmountCart.getTotal()));
            return "integrated:cart";
        }
        catch (UnknowTypeReductionException exception) {
            return "redirect:/errorOccured?code=invalid.promo.unknown";
        }
    }

    @RequestMapping(value = "/cart/addProduct",
                    method = RequestMethod.POST)
    public String postAddProduct(Model model,
                                 Locale locale,
                                 @Valid @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm,
                                 BindingResult errorsForm,
                                 @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart,
                                 BindingResult errors) {

        if (errorsForm.hasErrors()) {
            return "redirect:/errorOccured?code=Min.productCart.quantity";
        }

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
            return "redirect:/errorOccured?code=invalid.product.exist";
        } catch (QuantityIsNegativeException e) {
            return "redirect:/errorOccured?code=Min.productCart.quantity";
        }
    }

    @RequestMapping(value = "/cart/removeProduct",
                    method = RequestMethod.POST)
    public String postRemoveProduct(Model model,
                                    Locale locale,
                                    @Valid @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm,
                                    BindingResult errorsForm,
                                    @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart,
                                    BindingResult errors) {
        /*
        if (errorsForm.hasErrors()) {
            model.addAttribute("errorMessage", messageSource.getMessage("invalid.quantity.minus", null, locale));
            return "integrated:keyError";
        }
        */
        if (errorsForm.hasErrors()) {
            return "redirect:/errorOccured?code=Min.productCart.quantity";
        }

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
            return "redirect:/errorOccured?code=Min.productCart.quantity";
        }
    }

    @RequestMapping(value = "/cart/setProduct",
                    method = RequestMethod.POST)
    public String postSetProduct(Model model,
                                    Locale locale,
                                    @Valid @ModelAttribute(Constants.PRODUCT_TO_CART_FORM) ProductForm productForm,
                                    BindingResult errorsForm,
                                    @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart,
                                    BindingResult errors) {
        /*
        if (errorsForm.hasErrors()) {
            model.addAttribute("errorMessage", messageSource.getMessage("invalid.quantity.minus", null, locale));
            return "integrated:keyError";
        }
        */
        if (errorsForm.hasErrors()) {
            return "redirect:/errorOccured?code=Min.productCart.quantity";
        }

        try {
            Integer productId = productForm.getProductId();
            Integer quantity = productForm.getQuantity();
            Product product = productService.findOne(productId);

            if (cart.containsKey(productId)) {
                if (quantity <= 0) {
                    cart.remove(productId);
                } else {
                    cart.get(productId).setQuantity(quantity);
                }
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
            model.addAttribute("errorMessage", messageSource.getMessage("Min.productCart.quantity", null, locale));
            return "integrated:keyError";
        }
        catch (ProductNotFoundException e) {
            model.addAttribute("errorMessage", messageSource.getMessage("invalid.product.exist", null, locale));
            return "integrated:keyError";
        }
    }

    @RequestMapping(value = "/cart/confirmCart", method = RequestMethod.GET)
    public String postCartConfirm(Model model,
                                  Locale locale,
                                  @ModelAttribute(Constants.CART)HashMap<Integer, ProductCart> cart,
                                  BindingResult errors,
                                  Authentication authentication) {
        if (cart.size() <= 0) {
            model.addAttribute("errorMessage", messageSource.getMessage("invalid.cart.empty", null, locale));
            return "integrated:keyError";
        }

        try {
            // Calcul du montant total et du montant de la réduction
            FinalAmountCart finalAmountCart = this.cartService.getFinalAmountCart(cart);

            // Enregistrer le cart en db (order/orderline)
            cartService.saveCart(cart, authentication);

            // Afficher le formulaire de paiement Paypal
            model.addAttribute("title", messageSource.getMessage("cart.payment.title", null, locale));
            model.addAttribute("amount", finalAmountCart.getTotal());
            model.addAttribute("item_name", messageSource.getMessage("cart.item_name", null, locale));
            model.addAttribute("return_url", Constants.PAYMENT_RETURN_URL); // TODO URL payment is successful
            model.addAttribute("cancel_return_url", Constants.PAYMENT_CANCELLED_URL); // TODO URL payment is cancelled
            model.addAttribute("currency_code", Constants.CURRENCY_CODE);
            model.addAttribute("lc","US");

            // Vider le cart
            cart = new HashMap<>();

            return "integrated:pay";
        }
        catch (UnknowTypeReductionException exception) {
            return "redirect:/errorOccured?code=invalid.promo.unknown";
        }
    }
}
