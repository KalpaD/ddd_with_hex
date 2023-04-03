package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.mapper;

import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.request.OrderCreateRequest;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.response.OrderCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderRestMapper {

    @Mapping(target = "totalCost", ignore = true)
    @Mapping(target = "status", ignore = true)
    Order toProduct(OrderCreateRequest request);

    OrderCreateResponse toProductCreateResponse(Order order);
}
