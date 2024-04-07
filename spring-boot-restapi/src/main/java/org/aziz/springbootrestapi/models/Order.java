package org.aziz.springbootrestapi.models;

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
public class Order {
    private UUID id;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private double totalAmount;
    private OrderStatus status;
}
