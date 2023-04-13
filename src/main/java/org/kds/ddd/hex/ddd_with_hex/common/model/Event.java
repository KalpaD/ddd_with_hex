package org.kds.ddd.hex.ddd_with_hex.common.model;

public interface Event<T> {
    T toUseCase();
}
