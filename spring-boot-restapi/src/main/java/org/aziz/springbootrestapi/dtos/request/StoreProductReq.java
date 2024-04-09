package org.aziz.springbootrestapi.dtos.request;

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
public class StoreProductReq {
    private UUID id;
    private LocalDateTime addedAt;
    private UUID storeId;
    private UUID productId;
}
