package com.modules.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;

    private String email;

    static {
        System.out.println("Customer class static code trigger");
    }
}
