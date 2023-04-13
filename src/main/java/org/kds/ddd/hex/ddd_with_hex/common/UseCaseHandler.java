package org.kds.ddd.hex.ddd_with_hex.common;

import org.kds.ddd.hex.ddd_with_hex.common.model.UseCase;

/**
 * Act as the contract for the use case handler
 *
 * @param <R> Return object type for the UseCase
 * @param <U> Use case for the handler
 */
public interface UseCaseHandler<R, U extends UseCase> {

    R handle(U useCase);
}
