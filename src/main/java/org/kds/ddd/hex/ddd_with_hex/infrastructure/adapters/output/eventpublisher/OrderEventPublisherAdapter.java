package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.eventpublisher;

import org.kds.ddd.hex.ddd_with_hex.domain.event.OrderCreatedEvent;
import org.kds.ddd.hex.ddd_with_hex.application.ports.output.OrderEventPublisher;
import org.springframework.context.ApplicationEventPublisher;


public class OrderEventPublisherAdapter implements OrderEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public OrderEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(OrderCreatedEvent orderCreatedEvent) {
        applicationEventPublisher.publishEvent(orderCreatedEvent);
    }
}
