package org.kds.ddd.hex.ddd_with_hex.common;

import org.kds.ddd.hex.ddd_with_hex.common.model.UseCase;

public class ObservableUseCasePublisher extends BeanAwareUseCasePublisher {

    public <R, T extends UseCase> void register(Class<T> useCaseClass, UseCaseHandler<R, T> useCaseHandler) {
        UseCaseHandlerRegistry.INSTANCE.register(useCaseClass, useCaseHandler);
    }
}
