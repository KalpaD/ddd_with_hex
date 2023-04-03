package org.kds.ddd.hex.ddd_with_hex.domain.service;

import org.kds.ddd.hex.ddd_with_hex.domain.event.OrderCreated;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;
import org.kds.ddd.hex.ddd_with_hex.application.ports.input.CrateOrderUseCase;
import org.kds.ddd.hex.ddd_with_hex.application.ports.output.OrderEventPublisher;
import org.kds.ddd.hex.ddd_with_hex.application.ports.output.OrderPersistencePort;

public class OrderCreateService implements CrateOrderUseCase {
    private final OrderPersistencePort orderRepository;
    private final OrderEventPublisher orderEventPublisher;

    public OrderCreateService(OrderPersistencePort orderRepository,
                              OrderEventPublisher orderEventPublisher) {
        this.orderRepository = orderRepository;
        this.orderEventPublisher = orderEventPublisher;
    }

    @Override
    public Order create(Order order) {
        orderRepository.saveOrder(order);
        orderEventPublisher.publishOrderCreatedEvent(
                OrderCreated.builder()
                        .id(order.getId())
                        .build()
        );
        return order;
    }
}
