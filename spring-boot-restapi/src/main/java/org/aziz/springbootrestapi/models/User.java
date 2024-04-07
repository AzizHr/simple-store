package org.aziz.springbootrestapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
