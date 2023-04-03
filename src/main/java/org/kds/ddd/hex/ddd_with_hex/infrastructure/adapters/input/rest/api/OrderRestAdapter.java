package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.api;

import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.request.OrderCreateRequest;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.response.OrderCreateResponse;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.mapper.OrderRestMapper;
import org.kds.ddd.hex.ddd_with_hex.application.ports.input.CrateOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class OrderRestAdapter {

    private final CrateOrderUseCase crateOrderUseCase;
    private final OrderRestMapper orderRestMapper;

    public OrderRestAdapter(CrateOrderUseCase crateOrderUseCase, OrderRestMapper orderRestMapper) {
        this.crateOrderUseCase = crateOrderUseCase;
        this.orderRestMapper = orderRestMapper;
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderCreateRequest request) {
        var order = orderRestMapper.toProduct(request);
        order  = crateOrderUseCase.create(order);
        return new ResponseEntity<>(orderRestMapper.toProductCreateResponse(order), HttpStatus.CREATED);
    }
}
