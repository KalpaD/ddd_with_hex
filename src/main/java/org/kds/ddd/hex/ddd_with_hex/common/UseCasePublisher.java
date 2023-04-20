package org.kds.ddd.hex.ddd_with_hex.common;

import org.kds.ddd.hex.ddd_with_hex.common.model.UseCase;

/**
 * The contract for publishing use cases to application wide use case handlers.
 * The use cases which use this publisher returns a result from the use case.
 */
public interface UseCasePublisher {
    <R, U extends UseCase> R publish(Class<R> returnClass, U useCase);

    <R, T extends UseCase> void publish(T useCase);
}
