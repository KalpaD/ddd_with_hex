package org.kds.ddd.hex.ddd_with_hex.common;

import org.kds.ddd.hex.ddd_with_hex.common.model.UseCase;

public interface UseCasePublisher {

    <R, U extends UseCase> R publish(Class<R> returnClass, U useCase);

    <R, T extends UseCase> void publish(T useCase);
}
