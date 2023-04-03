package org.kds.ddd.hex.ddd_with_hex.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.kds.ddd.hex.ddd_with_hex.arch.DddEntity;

@DddEntity
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {
    String id;
    String name;
    Money price;
}
