package org.kds.ddd.hex.ddd_with_hex.application.ports.input;

import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;

public interface CrateOrderUseCase {

    Order create(Order order);
}
