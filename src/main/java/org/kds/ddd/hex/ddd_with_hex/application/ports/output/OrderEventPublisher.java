package org.kds.ddd.hex.ddd_with_hex.application.ports.output;

import org.kds.ddd.hex.ddd_with_hex.arch.hex.DrivenPort;
import org.kds.ddd.hex.ddd_with_hex.domain.event.OrderCreatedEvent;

@DrivenPort
public interface OrderEventPublisher {
    void publish(OrderCreatedEvent orderCreatedEvent);
}
