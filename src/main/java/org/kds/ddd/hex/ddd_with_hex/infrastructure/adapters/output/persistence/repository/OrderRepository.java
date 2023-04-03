package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.repository;

import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, String> {
}
