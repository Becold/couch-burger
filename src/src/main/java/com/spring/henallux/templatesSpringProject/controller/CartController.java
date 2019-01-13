package com.spring.henallux.templatesSpringProject.controller;

import com.spring.henallux.templatesSpringProject.Constants;
import com.spring.henallux.templatesSpringProject.exception.ProductNotFoundException;
import com.spring.henallux.templatesSpringProject.exception.QuantityIsNegativeException;
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
        FinalAmountCart finalAmountCart = this.cartService.getFinalAmountCart(cart);

        model.addAttribute("title",  messageSource.getMessage("menu.cart",null,locale));
        model.addAttribute("totalAmountReduction", finalAmountCart.getReduction());
        model.addAttribute("totalAmountReductionFormatted", String.format("%.2f", finalAmountCart.getReduction()));
        model.addAttribute("totalPrice", String.format("%.2f", finalAmountCart.getTotal()));
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
            model.addAttribute("errorMessage", "invalid.product.exist");
            return "integrated:keyError";
        } catch (QuantityIsNegativeException e) {
            model.addAttribute("errorMessage", "invalid.quantity.minus");
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
            model.addAttribute("errorMessage", "invalid.quantity.minus");
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
            model.addAttribute("errorMessage", "invalid.quantity.minus");
            return "integrated:keyError";
        }
        catch (ProductNotFoundException e) {
            model.addAttribute("errorMessage", "invalid.product.exist");
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
            model.addAttribute("errorMessage", "invalid.cart.empty");
            return "integrated:keyError";
        }

        // Calcul du montant total et du montant de la réduction
        FinalAmountCart finalAmountCart = this.cartService.getFinalAmountCart(cart);

        // Enregistrer le cart en db (order/orderline)
        cartService.saveCart(cart, authentication);

        // Afficher le formulaire de paiement Paypal
        model.addAttribute("title",  messageSource.getMessage("cart.payment.title",null,locale));
        model.addAttribute("amount", finalAmountCart.getTotal());
        model.addAttribute("item_name", messageSource.getMessage("cart.item_name",null,locale));
        model.addAttribute("return_url", Constants.PAYMENT_RETURN_URL); // TODO URL payment is successful
        model.addAttribute("cancel_return_url", Constants.PAYMENT_CANCELLED_URL); // TODO URL payment is cancelled
        model.addAttribute("currency_code", Constants.CURRENCY_CODE);
        model.addAttribute("lc", locale.getLanguage());

        // Vider le cart
        cart = new HashMap<>();

        return "integrated:pay";
    }
}
