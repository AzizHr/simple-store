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
public class ProductResponse {
    private UUID id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String type;
    private CategoryResponse category;
    private List<VariantResponse> variants;
    private List<MediaResponse> mediaList;
}
