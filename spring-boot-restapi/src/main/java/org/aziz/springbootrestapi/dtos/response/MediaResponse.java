package org.aziz.springbootrestapi.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aziz.springbootrestapi.enums.MediaType;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MediaResponse {
    private UUID id;
    private String url;
    private MediaType type;
}
