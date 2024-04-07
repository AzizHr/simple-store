package org.aziz.springbootrestapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String type;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Variant> variants;
    @ManyToOne
    private Store store;
    @OneToMany(mappedBy = "product")
    private List<ShoppingCartProduct> shoppingCarts;
}
