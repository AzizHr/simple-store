package org.aziz.springbootrestapi.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private UUID id;
    private String country;
    private String city;
    private String street;
    private String postalCode;
}
