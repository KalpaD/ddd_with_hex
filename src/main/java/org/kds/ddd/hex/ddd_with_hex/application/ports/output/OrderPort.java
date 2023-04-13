package org.kds.ddd.hex.ddd_with_hex.application.ports.output;

import org.kds.ddd.hex.ddd_with_hex.arch.hex.DrivenPort;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;

import java.util.Optional;

@DrivenPort
public interface OrderPort {
    Order create(Order order);
    Optional<Order> getOrderById(String id);
}
