package org.kds.ddd.hex.ddd_with_hex.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    @DisplayName("should calculate the total cost correctly when order created")
    void createOrderSuccess() {
        // prepare
        String orderId = "123456";
        Customer customer = Customer.builder()
                .id("12345")
                .name("John")
                .email("john.doe@gmail.com")
                .address(
                        Address.builder()
                                .build()
                ).build();
        List<OrderItem> items = List.of(
                createOrderItem("123", 250, 1),
                createOrderItem("124", 253, 2)
        );

        // execute
        Order order = Order.createOrder(orderId, customer, items);

        // assert
        Money actualTotalCost = order.getTotalCost();
        Money expectedTotalCost = Money.builder()
                .amount(BigDecimal.valueOf(756))
                .currency(Currency.getInstance("AUD"))
                .build();
        assertEquals(expectedTotalCost, actualTotalCost);
    }

    private OrderItem createOrderItem(String id,
                                      long value,
                                      int quantity) {
        return OrderItem.builder()
                .product(Product.builder()
                        .id(id)
                        .price(Money.builder()
                                .currency(
                                        Currency.getInstance("AUD")
                                )
                                .amount(BigDecimal.valueOf(value))
                                .build())
                        .build())
                .quantity(quantity)
                .build();
    }

    @Test
    @DisplayName("should calculate the total cost correctly when new order item added to existing order")
    void addItem() {
        // prepare
        String orderId = "123456";
        Customer customer = Customer.builder()
                .id("12345")
                .name("John")
                .email("john.doe@gmail.com")
                .address(
                        Address.builder()
                                .build()
                ).build();
        List<OrderItem> items = new ArrayList<>();
        items.add(createOrderItem("123", 250, 1));

        // execute
        Order order = Order.createOrder(orderId, customer, items);
        OrderItem orderItem = createOrderItem("124", 253, 2);
        order.addItem(orderItem);

        // assert
        Money actualTotalCost = order.getTotalCost();
        Money expectedTotalCost = Money.builder()
                .amount(BigDecimal.valueOf(756))
                .currency(Currency.getInstance("AUD"))
                .build();
        assertEquals(expectedTotalCost, actualTotalCost);
    }
}