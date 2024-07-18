package org.spring.practice01.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketDTO {
        private Integer id;
        private Integer cusId;
        private Integer goodsId;
        private String goodsName;
        private Integer goodsCount;
        private Integer goodsPrice;
        private String nickname;

}
