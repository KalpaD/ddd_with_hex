package org.kds.ddd.hex.ddd_with_hex.application.ports.input.usecasehandler;

import org.kds.ddd.hex.ddd_with_hex.application.ports.output.OrderEventPublisher;
import org.kds.ddd.hex.ddd_with_hex.application.ports.output.OrderPort;
import org.kds.ddd.hex.ddd_with_hex.application.ports.input.usecase.CrateOrder;
import org.kds.ddd.hex.ddd_with_hex.arch.ddd.DddUseCaseHandler;
import org.kds.ddd.hex.ddd_with_hex.arch.hex.DriverPort;
import org.kds.ddd.hex.ddd_with_hex.common.ObservableUseCasePublisher;
import org.kds.ddd.hex.ddd_with_hex.common.UseCaseHandler;
import org.kds.ddd.hex.ddd_with_hex.domain.event.OrderCreatedEvent;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
@DddUseCaseHandler
@DriverPort
public class OrderCreateUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<Order, CrateOrder> {

    private final OrderPort orderPort;
    private final OrderEventPublisher orderEventPublisher;

    public OrderCreateUseCaseHandler(OrderPort orderPort,
                                     OrderEventPublisher orderEventPublisher) {
        this.orderPort = orderPort;
        this.orderEventPublisher = orderEventPublisher;
        register(CrateOrder.class, this);
    }

    @Override
    public Order handle(CrateOrder crateOrder) {
        var order = Order.createOrder(crateOrder.getId(), crateOrder.getCustomer(), crateOrder.getItems());
        order = orderPort.create(order);
        orderEventPublisher.publish(OrderCreatedEvent.builder()
                .customer(crateOrder.getCustomer())
                .id(order.getId())
                .build());
        return order;
    }
}
