package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.config;

import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.eventpublisher.OrderEventPublisherAdapter;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.OrderPersistenceAdapter;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.mapper.OrderPersistenceMapper;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Infrastructure adapters get created here.
 */
@Configuration
public class AdapterConfiguration {
    @Bean
    public OrderPersistenceAdapter orderPersistenceAdapter(OrderRepository repository, OrderPersistenceMapper mapper) {
        return new OrderPersistenceAdapter(repository, mapper);
    }

    @Bean
    public OrderEventPublisherAdapter orderEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new OrderEventPublisherAdapter(applicationEventPublisher);
    }

}
