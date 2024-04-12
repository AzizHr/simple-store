package org.aziz.springbootrestapi.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aziz.springbootrestapi.dtos.request.ShoppingCartRequest;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartProductResponse {
    private UUID id;
    private int quantity;
    private ShoppingCartRequest shoppingCart;
    private ProductResponse product;
}
