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
class Payment {
    String id;
    Order order;
    Money amount;
    PaymentStatus status;
}
