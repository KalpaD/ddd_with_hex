package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItem {
    Product product;
    int quantity;
}
