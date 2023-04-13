package org.kds.ddd.hex.ddd_with_hex.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.kds.ddd.hex.ddd_with_hex.arch.ddd.DddEntity;

@DddEntity
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItem {
    Product product;
    int quantity;
}
