package org.kds.ddd.hex.ddd_with_hex.domain.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.kds.ddd.hex.ddd_with_hex.application.ports.input.usecase.NotifyCustomer;
import org.kds.ddd.hex.ddd_with_hex.arch.ddd.DddEvent;
import org.kds.ddd.hex.ddd_with_hex.common.model.Event;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Customer;


@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@DddEvent
public class OrderCreatedEvent implements Event<NotifyCustomer> {

    @NonNull
    String id;
    @NonNull
    Customer customer;

    @Override
    public NotifyCustomer toUseCase() {
        return NotifyCustomer.builder()
                .id(id)
                .customer(customer)
                .build();
    }
}
