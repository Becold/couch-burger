package com.spring.henallux.templatesSpringProject.service;

import com.spring.henallux.templatesSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.templatesSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.templatesSpringProject.model.Order;
import com.spring.henallux.templatesSpringProject.model.OrderLine;
import com.spring.henallux.templatesSpringProject.model.Product;
import com.spring.henallux.templatesSpringProject.model.Promotion;
import com.spring.henallux.templatesSpringProject.model.form.cart.ProductCart;
import org.apache.tiles.request.collection.MapEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private ProductService productService;
    private OrderService orderService;
    private OrderLineService orderLineService;

    @Autowired
    public CartService(ProductService productService,
                       OrderService orderService,
                       OrderLineService orderLineService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderLineService = orderLineService;
    }

    public Double getTotalPrice(HashMap<Integer, ProductCart> cart, ArrayList<Promotion> promotions) {
        // TODO Promotions
        Double totalPrice = 0.00;
        for (Map.Entry<Integer, ProductCart> entry : cart.entrySet()) {
            Product item = entry.getValue().getProduct();
            Integer quantity = entry.getValue().getQuantity();
            totalPrice += this.orderLineService.getPrice(quantity, item, promotions);
        }
        return totalPrice;
    }

    public String getFormattedTotalPrice(HashMap<Integer, ProductCart> cart, ArrayList<Promotion> promotions) {
        return String.format("%.2f", this.getTotalPrice(cart, promotions));
    }

    @Transactional
    public void saveCart(HashMap<Integer, ProductCart> cart,
                         ArrayList<Promotion> promotions,
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
                            item.getProduct(),
                            promotions
                    )
            );
            this.orderLineService.save(orderLine);
        }
    }
}
