package org.aziz.springbootrestapi.models;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {
    @OneToOne(mappedBy = "customer")
    private ShoppingCart shoppingCart;
}
