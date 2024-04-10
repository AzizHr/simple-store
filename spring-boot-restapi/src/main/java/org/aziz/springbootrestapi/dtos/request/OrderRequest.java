package org.aziz.springbootrestapi.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aziz.springbootrestapi.enums.OrderStatus;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private UUID id;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private OrderStatus status;
    private double totalAmount;
    private UUID shoppingCartId;
}
