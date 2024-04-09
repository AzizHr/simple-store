package org.aziz.springbootrestapi.dtos.response;

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
public class ShoppingCartRes {
    private UUID id;
    private String name;
    private List<ProductRes> products;
    private OrderRes order;
}
