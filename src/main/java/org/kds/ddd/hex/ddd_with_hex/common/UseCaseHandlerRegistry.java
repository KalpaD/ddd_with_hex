package org.kds.ddd.hex.ddd_with_hex.common;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kds.ddd.hex.ddd_with_hex.common.model.UseCase;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This registry keeps the mappings between use cases and their relevant use case handlers
 * All user case handlers MUST register here at their initialisation.
 */
@Slf4j
@Getter
public class UseCaseHandlerRegistry {

    private final Map<Class<? extends UseCase>, UseCaseHandler<?, ? extends UseCase>> registryForUseCaseHandlers;
    private final Map<Class<? extends UseCase>, VoidUseCaseHandler<? extends UseCase>> registryForVoidUseCaseHandlers;

    public static final UseCaseHandlerRegistry INSTANCE = new UseCaseHandlerRegistry();

    private UseCaseHandlerRegistry() {
        registryForUseCaseHandlers = new ConcurrentHashMap<>();
        registryForVoidUseCaseHandlers = new ConcurrentHashMap<>();
    }

    public <R, T extends UseCase> void register(Class<T> key, UseCaseHandler<R, T> useCaseHandler) {
        log.info("Use case {} is registered by handler {}", key.getSimpleName(), useCaseHandler.getClass().getSimpleName());
        registryForUseCaseHandlers.put(key, useCaseHandler);
    }

    public UseCaseHandler<?, ? extends UseCase> detectUseCaseHandlerFrom(Class<? extends UseCase> useCaseClass) {
        return registryForUseCaseHandlers.get(useCaseClass);
    }

    public VoidUseCaseHandler<? extends UseCase> detectVoidUseCaseHandlerFrom(Class<? extends UseCase> useCaseClass) {
        return registryForVoidUseCaseHandlers.get(useCaseClass);
    }
}
