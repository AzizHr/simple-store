package org.aziz.springbootrestapi.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aziz.springbootrestapi.enums.Role;
import org.aziz.springbootrestapi.models.Address;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private Address address;
}
