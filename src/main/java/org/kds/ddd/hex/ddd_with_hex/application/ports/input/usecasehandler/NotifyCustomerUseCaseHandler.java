package org.kds.ddd.hex.ddd_with_hex.application.ports.input.usecasehandler;

import lombok.extern.slf4j.Slf4j;
import org.kds.ddd.hex.ddd_with_hex.application.ports.input.usecase.NotifyCustomer;
import org.kds.ddd.hex.ddd_with_hex.arch.ddd.DddUseCaseHandler;
import org.kds.ddd.hex.ddd_with_hex.arch.hex.DriverPort;
import org.kds.ddd.hex.ddd_with_hex.common.ObservableUseCasePublisher;
import org.kds.ddd.hex.ddd_with_hex.common.UseCaseHandler;
import org.kds.ddd.hex.ddd_with_hex.common.exception.OrderApiException;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Channels;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Notification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@DddUseCaseHandler
@DriverPort
public class NotifyCustomerUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<Notification, NotifyCustomer> {

    public NotifyCustomerUseCaseHandler() {
        register(NotifyCustomer.class, this);
    }

    @Override
    public Notification handle(NotifyCustomer useCase) {
        if (!useCase.getCustomer().getEmail().isBlank()) {
           var notification =  Notification.builder()
                    .id(UUID.randomUUID().toString())
                    .channels(List.of(Channels.EMAIL))
                    .message("Your order has been successfully created!")
                    .build();
           log.info("Sending notification {} :", notification);
           return notification;
        } else {
            throw new OrderApiException("At-least one notification channel must be present");
        }
    }
}
