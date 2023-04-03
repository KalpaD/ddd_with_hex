package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItem {
    Product product;
    int quantity;
}
