package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCreateRequest {
    String id;
    Customer customer;
    List<OrderItem> items;
}
