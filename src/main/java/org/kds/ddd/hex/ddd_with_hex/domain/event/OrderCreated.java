package org.kds.ddd.hex.ddd_with_hex.domain.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCreated {
    String id;
}
