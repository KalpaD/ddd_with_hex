package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.eventlistener;

import lombok.extern.slf4j.Slf4j;
import org.kds.ddd.hex.ddd_with_hex.domain.event.OrderCreated;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class OrderEventListener {

    @EventListener
    void handle(OrderCreated event) {
        log.info("Order created with id " + event.getId());
    }
}
