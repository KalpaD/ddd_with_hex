package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Currency;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Money {
    BigDecimal amount;
    Currency currency;
}
