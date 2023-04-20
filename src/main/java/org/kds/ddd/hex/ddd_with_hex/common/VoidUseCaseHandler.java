package org.kds.ddd.hex.ddd_with_hex.common;

import org.kds.ddd.hex.ddd_with_hex.common.model.UseCase;

/**
 *  * The contract for publishing use cases to application wide use case handlers.
 *  * The use cases which use this publisher does not expect a from the use case.
 * @param <T> UseCase
 */
public interface VoidUseCaseHandler<T extends UseCase> {
    void handle(T useCase);
}
