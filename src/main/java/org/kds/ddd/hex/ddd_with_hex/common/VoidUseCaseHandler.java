package org.kds.ddd.hex.ddd_with_hex.common;

import org.kds.ddd.hex.ddd_with_hex.common.model.UseCase;

public interface VoidUseCaseHandler<T extends UseCase> {

    void handle(T useCase);
}
