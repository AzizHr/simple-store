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
public class StoreRequest {
    private UUID id;
    private String name;
    private String description;
    private UUID sellerId;
}
