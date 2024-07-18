package org.spring.practice01.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDTO {
    private Integer id;
    private String name;
    private Integer goodsCategory;
    private Integer price;
    private Integer categoryId;
    private String categoryName;
}
