package org.aziz.springbootrestapi.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aziz.springbootrestapi.models.Category;
import org.aziz.springbootrestapi.models.Variant;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRes {
    private UUID id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String type;
    private CategoryRes category;
    private List<VariantRes> variants;
}
