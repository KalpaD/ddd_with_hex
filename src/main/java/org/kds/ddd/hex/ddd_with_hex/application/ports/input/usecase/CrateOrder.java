package org.kds.ddd.hex.ddd_with_hex.application.ports.input.usecase;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.kds.ddd.hex.ddd_with_hex.arch.ddd.DddUseCase;
import org.kds.ddd.hex.ddd_with_hex.common.model.UseCase;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Customer;
import org.kds.ddd.hex.ddd_with_hex.domain.model.OrderItem;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@DddUseCase
public class CrateOrder implements UseCase {
    @NonNull
    private String id;
    @NonNull
    private Customer customer;
    @NonNull
    private List<OrderItem> items;
}
