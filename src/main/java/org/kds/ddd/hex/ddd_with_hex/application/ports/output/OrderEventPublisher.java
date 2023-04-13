package org.kds.ddd.hex.ddd_with_hex.application.ports.output;

import org.kds.ddd.hex.ddd_with_hex.domain.event.OrderCreatedEvent;

public interface OrderEventPublisher {

    void publish(OrderCreatedEvent orderCreatedEvent);
}
