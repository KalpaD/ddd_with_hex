package org.kds.ddd.hex.ddd_with_hex.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.kds.ddd.hex.ddd_with_hex.arch.ddd.DddValueObject;

import java.math.BigDecimal;
import java.util.Currency;

@DddValueObject
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Money {
    BigDecimal amount;
    Currency currency;
}
