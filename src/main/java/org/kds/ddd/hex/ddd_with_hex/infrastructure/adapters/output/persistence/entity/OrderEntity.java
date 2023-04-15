package org.kds.ddd.hex.ddd_with_hex.infrastructure.adapters.output.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kds.ddd.hex.ddd_with_hex.arch.ddd.DbEntity;
import org.kds.ddd.hex.ddd_with_hex.domain.model.Customer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("orders")
@DbEntity
public class OrderEntity {
    @Id
    private String id;
    private Customer customer;
    private List<OrderItem> items;
    private Money totalCost;
    private String status;
}
