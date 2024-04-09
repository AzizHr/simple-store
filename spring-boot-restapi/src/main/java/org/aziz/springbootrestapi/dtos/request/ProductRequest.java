package org.aziz.springbootrestapi.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aziz.springbootrestapi.models.Variant;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private UUID id;
    @NotEmpty(message = "المرجو إضافة إسم المنتج")
    private String name;
    @NotEmpty(message = "المرجو إضافة ثمن المنتج")
    @Size(message = "ثمن المنتج يجب أن يكون أكبر من 0 درهم", min = 1)
    private double price;
    @NotEmpty(message = "المرجو إضافة كمية المنتج")
    @Size(message = "كمية المنتج يجب أن تكون أكبر من 0", min = 1)
    private int quantity;
    @NotEmpty(message = "المرجو إضافة وصف للمنتج")
    private String description;
    @NotEmpty(message = "المرجو إضافة نوع المنتج")
    private String type;
    @NotEmpty(message = "المرجو إضافة فئة المنتج")
    private UUID categoryId;
    private List<Variant> variants;
}
