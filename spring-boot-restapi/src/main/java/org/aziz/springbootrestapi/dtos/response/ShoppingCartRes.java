package org.aziz.springbootrestapi.dtos.response;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aziz.springbootrestapi.models.Customer;
import org.aziz.springbootrestapi.models.Order;
import org.aziz.springbootrestapi.models.ShoppingCartProduct;
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
    private Order order;
}
