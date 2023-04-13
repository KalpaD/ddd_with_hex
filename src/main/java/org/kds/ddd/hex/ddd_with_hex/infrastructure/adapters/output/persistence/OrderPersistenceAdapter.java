package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence;

import org.kds.ddd.hex.ddd_with_hex.arch.hex.Adapter;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.mapper.OrderPersistenceMapper;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.repository.OrderRepository;
import org.kds.ddd.hex.ddd_with_hex.application.ports.output.OrderPort;

import java.util.Optional;

@Adapter
public class OrderPersistenceAdapter implements OrderPort {

    private final OrderRepository orderRepository;
    private final OrderPersistenceMapper mapper;

    public OrderPersistenceAdapter(OrderRepository orderRepository, OrderPersistenceMapper mapper) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
    }

    @Override
    public Order create(Order order) {
        var orderEntity = mapper.toOrderEntity(order);
        orderRepository.save(orderEntity);
        return order;
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        return Optional.empty();
    }
}
