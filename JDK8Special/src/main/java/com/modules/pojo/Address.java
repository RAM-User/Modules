package com.modules.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String street;

    public String postCode;

    static {
        System.out.println("Address class static code trigger");
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    public static String publicMethod() {
        return "this is a public method";
    }

    private static String privateMethodWithParameter(String parameter) {
        return "this is a private method with " + parameter;
    }
}
