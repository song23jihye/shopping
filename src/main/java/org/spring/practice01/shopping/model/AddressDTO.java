package org.spring.practice01.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private int id; //배송지 id
    private int cusIdAddress;
    private String province;
    private String city;
    private Integer streetNumber;
}
