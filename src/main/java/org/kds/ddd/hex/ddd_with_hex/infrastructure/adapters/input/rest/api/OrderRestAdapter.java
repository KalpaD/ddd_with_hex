package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.api;

import org.kds.ddd.hex.ddd_with_hex.arch.hex.Adapter;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Order;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.request.OrderCreateRequest;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.dto.response.OrderCreateResponse;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.input.rest.mapper.OrderRestMapper;
import org.kds.ddd.hex.ddd_with_hex.infrastructure.common.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Adapter
public class OrderRestAdapter extends BaseController {
    private final OrderRestMapper orderRestMapper;

    public OrderRestAdapter(OrderRestMapper orderRestMapper) {
        this.orderRestMapper = orderRestMapper;
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderCreateRequest request) {
        var createOrderUseCase = orderRestMapper.toProduct(request);
        Order order = publish(Order.class, createOrderUseCase);
        return new ResponseEntity<>(orderRestMapper.toProductCreateResponse(order), HttpStatus.CREATED);
    }
}
