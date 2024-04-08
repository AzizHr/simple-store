package org.aziz.springbootrestapi.models;

import jakarta.persistence.*;
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
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private double totalAmount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @OneToOne(mappedBy = "order")
    private ShoppingCart shoppingCart;
}
