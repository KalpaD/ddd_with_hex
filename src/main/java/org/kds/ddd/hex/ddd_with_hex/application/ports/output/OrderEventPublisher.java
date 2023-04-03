package org.kds.ddd.hex.ddd_with_hex.application.ports.output;

import org.kds.ddd.hex.ddd_with_hex.domain.event.OrderCreated;

public interface OrderEventPublisher {

    void publishOrderCreatedEvent(OrderCreated orderCreated);
}
