package org.kds.ddd.hex.ddd_with_hex.application.ports.output;

import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;

import java.util.Optional;

public interface OrderPersistencePort {

    Order saveOrder(Order order);

    Optional<Order> getOrderById(String id);
}
