package org.kds.ddd.hex.ddd_with_hex.application.ports.output;

import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;

import java.util.Optional;

public interface OrderPort {

    Order create(Order order);

    Optional<Order> getOrderById(String id);
}
