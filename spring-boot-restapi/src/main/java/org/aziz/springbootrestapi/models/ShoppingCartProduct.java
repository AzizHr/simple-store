package org.aziz.springbootrestapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShoppingCartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(columnDefinition = "INT DEFAULT 1")
    private int quantity;
    @ManyToOne()
    private ShoppingCart shoppingCart;
    @ManyToOne
    private Product product;
}
