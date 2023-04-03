package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Money {
    String amount;
    String currency;
}
