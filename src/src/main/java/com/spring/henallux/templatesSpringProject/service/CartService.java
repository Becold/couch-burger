package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.model.Order;
import com.spring.henallux.templatesSpringProject.model.OrderLine;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductCart;
import com.spring.henallux.templatesSpringProject.model.promotion.FinalAmountCart;
import com.spring.henallux.templatesSpringProject.model.promotion.TypeReduction;
import org.apache.tiles.request.collection.MapEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CartService {

    private ProductService productService;
    private OrderService orderService;
    private OrderLineService orderLineService;
    private PromotionService promotionService;

    @Autowired
    public CartService(ProductService productService,
                       OrderService orderService,
                       OrderLineService orderLineService,
                       PromotionService promotionService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderLineService = orderLineService;
        this.promotionService = promotionService;
    }

    @Transactional
    public void saveCart(HashMap<Integer, ProductCart> cart,
                         Authentication authentication) {
        Order order = new Order();
        order.setUser(new ProviderConverter().userEntityToUserModel((UserEntity) authentication.getPrincipal()));
        order.setCreationDate(new GregorianCalendar());
        order.setPaid(false);
        Order createdOrder = this.orderService.create(order);

        for (Map.Entry<Integer, ProductCart> cartItem : cart.entrySet()) {
            ProductCart item = cartItem.getValue();

            OrderLine orderLine = new OrderLine();
            orderLine.setProduct(item.getProduct());
            orderLine.setOrder(createdOrder);
            orderLine.setQuantity(item.getQuantity());
            orderLine.setUnitPrice(
                    orderLineService.getPrice(
                            item.getQuantity(),
                            item.getProduct()
                    )
            );
            this.orderLineService.save(orderLine);
        }
    }

    public Double findBestPromotionForProduct(Product product, ArrayList<Promotion> promotions) {
        Double bestAmountReduction = 0.00;
        if (!promotions.isEmpty()) {
            Double amountReduction = 0.00;
            for (Promotion promotion : promotions) {
                if (promotion.getTypeReduction().equals(TypeReduction.FIXE)) {
                    amountReduction = promotion.getAmountReduction();
                }
                else if (promotion.getTypeReduction().equals(TypeReduction.POURCENTAGE)) {
                    amountReduction = product.getUnitPriceWithVat() * promotion.getAmountReduction();
                }
                else {
                    // TODO Exception : "Ce type de reduction n'existe pas"
                }

                if (bestAmountReduction < amountReduction) {
                    bestAmountReduction = amountReduction;
                }
            }
        }
        return bestAmountReduction;
    }

    public FinalAmountCart getFinalAmountCart(HashMap<Integer, ProductCart> cart) {
        FinalAmountCart finalAmountCart = new FinalAmountCart();
        GregorianCalendar currentDate = new GregorianCalendar();
        for(Map.Entry<Integer, ProductCart> item : cart.entrySet()) {
            Product product = item.getValue().getProduct();
            Integer quantity = item.getValue().getQuantity();

            ArrayList<Promotion> currentPromotions = this.promotionService.findCurrentPromotions(
                    currentDate,
                    product.getProductId(),
                    product.getCategory().getCategoryId()
            );

            Double amountReduction = this.findBestPromotionForProduct(product, currentPromotions);

            finalAmountCart.setReduction(finalAmountCart.getTotal() + amountReduction * (double)quantity);
            finalAmountCart.setTotal(finalAmountCart.getTotal() + (product.getUnitPriceWithVat() - amountReduction) * (double)quantity);
        }
        if (finalAmountCart.getTotal() < 0) {
            finalAmountCart.setTotal(1.00);
        }
        return finalAmountCart;
    }
}
