package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.mapper;

import org.kds.ddd.hex.ddd_with_hex.application.ports.input.usecase.CrateOrder;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.request.OrderCreateRequest;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.response.OrderCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderRestMapper {

    CrateOrder toProduct(OrderCreateRequest request);

    @Mapping(target = "id", source = "id")
    OrderCreateResponse toProductCreateResponse(Order order);
}
