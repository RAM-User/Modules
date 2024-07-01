package com.modules.Reflection;

import com.modules.pojo.Address;
import com.modules.pojo.Customer;
import com.modules.pojo.Order;

public class main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Address address = new Address("spear", "91407");
        Customer customer = new Customer("ink2r", "ink2r@gmail.com");
        Order order = new Order(customer, address);


    }
}
