package org.aziz.springbootrestapi.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartProductReq {
    private UUID id;
    private int quantity;
    private UUID shoppingCartId;
    private UUID productId;
}
