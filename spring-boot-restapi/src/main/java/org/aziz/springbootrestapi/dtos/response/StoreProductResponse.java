package org.aziz.springbootrestapi.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProductResponse {
    private UUID id;
    private LocalDateTime addedAt;
    private StoreResponse store;
    private ProductResponse product;
}
