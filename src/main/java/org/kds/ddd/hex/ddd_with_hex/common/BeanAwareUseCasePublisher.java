package org.kds.ddd.hex.ddd_with_hex.common;

import lombok.extern.slf4j.Slf4j;
import org.kds.ddd.hex.ddd_with_hex.common.exception.OrderApiException;
import org.kds.ddd.hex.ddd_with_hex.common.model.UseCase;

import java.util.Objects;

@Slf4j
public class BeanAwareUseCasePublisher implements UseCasePublisher {
    @Override
    @SuppressWarnings("unchecked")
    public <R, U extends UseCase> R publish(Class<R> returnClass, U useCase) {
        var useCaseHandler = (UseCaseHandler<R, U>) UseCaseHandlerRegistry.INSTANCE.detectUseCaseHandlerFrom(useCase.getClass());
        validateUseCaseHandlerDetection(useCase, useCaseHandler);
        return useCaseHandler.handle(useCase);
    }

    private <R, T extends UseCase> void validateUseCaseHandlerDetection(T useCase, UseCaseHandler<R, T> useCaseHandler) {
        if (Objects.isNull(useCaseHandler)) {
            log.error("Use case handler cannot be detected for the use case: {}, handlers: {}", useCase, UseCaseHandlerRegistry.INSTANCE.getRegistryForUseCaseHandlers());
            throw new OrderApiException("orderApi.useCaseHandler.notDetected");
        }
    }

    @SuppressWarnings("unchecked")
    public <R, T extends UseCase> void publish(T useCase) {
        var voidUseCaseHandler = (VoidUseCaseHandler<T>) UseCaseHandlerRegistry.INSTANCE.detectVoidUseCaseHandlerFrom(useCase.getClass());
        if (Objects.isNull(voidUseCaseHandler)) {
            var useCaseHandler = (UseCaseHandler<R, T>) UseCaseHandlerRegistry.INSTANCE.detectUseCaseHandlerFrom(useCase.getClass());
            validateUseCaseHandlerDetection(useCase, useCaseHandler);
            useCaseHandler.handle(useCase);
        } else {
            validateVoidUseCaseHandlerDetection(useCase, voidUseCaseHandler);
            voidUseCaseHandler.handle(useCase);
        }
    }

    private <T extends UseCase> void validateVoidUseCaseHandlerDetection(T useCase, VoidUseCaseHandler<T> useCaseHandler) {
        if (Objects.isNull(useCaseHandler)) {
            log.error("Void use case handler cannot be detected for the use case: {}, handlers: {}", useCase, UseCaseHandlerRegistry.INSTANCE.getRegistryForVoidUseCaseHandlers());
            throw new OrderApiException("orderApi.useCaseHandler.notDetected");
        }
    }
}
