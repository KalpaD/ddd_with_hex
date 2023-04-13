package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.eventlistener;

import lombok.extern.slf4j.Slf4j;
import org.kds.ddd.hex.ddd_with_hex.common.BeanAwareUseCasePublisher;
import org.kds.ddd.hex.ddd_with_hex.common.exception.OrderApiException;
import org.kds.ddd.hex.ddd_with_hex.domain.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class OrderEventListener extends BeanAwareUseCasePublisher {

    @EventListener
    void handle(OrderCreatedEvent event) {
        log.info("Order created with id " + event.getCustomer());
        try {
            publish(event.toUseCase());
        } catch (OrderApiException e) {
            log.error("Failed to send the notification to customer for notification id {}", event.getCustomer(), e);
        }
    }
}
