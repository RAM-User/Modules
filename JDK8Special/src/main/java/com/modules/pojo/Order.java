package com.modules.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    private Customer customer;

    private Address address;

    static {
        System.out.println("Order class static code trigger");
    }
}
