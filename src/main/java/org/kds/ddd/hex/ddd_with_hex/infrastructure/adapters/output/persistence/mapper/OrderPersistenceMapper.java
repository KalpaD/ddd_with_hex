package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.mapper;

import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;
import org.kds.ddd.hex.ddd_with_hex.domain.model.OrderItem;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.entity.Money;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderPersistenceMapper {

    OrderEntity toOrderEntity(Order product);

    @Mapping(target = "amount", source = "amount", numberFormat = "#.##E0")
    org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.entity.Money map(org.kds.ddd.hex.ddd_with_hex.domain.model.Money value);

    org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.entity.OrderItem map(OrderItem value);

    Order toOrder(OrderEntity orderEntity);
}
