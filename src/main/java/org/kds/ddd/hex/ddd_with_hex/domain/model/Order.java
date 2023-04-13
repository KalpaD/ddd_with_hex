package org.kds.ddd.hex.ddd_with_hex.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.kds.ddd.hex.ddd_with_hex.arch.ddd.DddAggregate;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

@DddAggregate
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    private String id;
    private Customer customer;
    private List<OrderItem> items;
    private Money totalCost;
    private OrderStatus status;

    public static Order createOrder(String orderId,
                             Customer customer,
                             List<OrderItem> items) {
        return Order.builder()
                .id(orderId)
                .customer(customer)
                .items(items)
                .status(OrderStatus.CREATED)
                .totalCost(calculateTotalCost(items))
                .build();
    }

    private static Money calculateTotalCost(List<OrderItem> items) {
        BigDecimal totalPriceOfItems = calculateTotalPrice(items);
        return Money.builder()
                .amount(totalPriceOfItems)
                .currency(Currency.getInstance("AUD"))
                .build();
    }

    private static BigDecimal calculateTotalPrice(List<OrderItem> items) {
        return items.stream()
                .map(Order::calculatePriceOfOrderItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal calculatePriceOfOrderItem(OrderItem item) {
        BigDecimal itemPrice = item.getProduct()
                .getPrice()
                .getAmount();
        int quantity = item.getQuantity();
        return itemPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public boolean addItem(OrderItem orderItem) {
        if (Objects.isNull(orderItem)) {
            return false;
        }
        // update total cost
        items.add(orderItem);
        totalCost = calculateTotalCost(items);
        return true;
    }

}
