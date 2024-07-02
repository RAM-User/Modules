package com.modules.Reflection;

import com.modules.pojo.Address;
import com.modules.pojo.Customer;
import com.modules.pojo.Order;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
//        GetClass();
//        GetFiled();
          GetMethod();
    }

    public static void GetClass() {
        // 类字面常量 不触发类中静态代码块 初始化
        Class<Order> orderClass = Order.class;

        // 由于类实例对象
        Address address = new Address("spear", "91407");
        Class<?> addressClass = address.getClass();

        // 获取父类对象
        Class<?> superclass = addressClass.getSuperclass();

        // 根据类的完全限定名
        try {
            Class<?> customerClass = Class.forName("com.modules.pojo.Customer");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void GetFiled() throws NoSuchFieldException {
        Address address = new Address("spear", "91407");
        Class<? extends Address> addressClass = address.getClass();

        // 获取所有权限字段
        Field[] allField = addressClass.getDeclaredFields();
        Field[] publicFiled = addressClass.getFields();

        // 获取仅public权限字段
        Field street = addressClass.getDeclaredField("street");
        Field postCode = addressClass.getField("postCode");

        // 获取字段类型
        Class<?> type = street.getType();
        Type genericType = street.getGenericType();

    }

    public static void GetMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Class<?> addressClass = Class.forName("com.modules.pojo.Address");

        Method[] addressClassDeclaredMethods = addressClass.getDeclaredMethods();

        Method publicMethod = addressClass.getDeclaredMethod("publicMethod");
        System.out.println(publicMethod.invoke(null));

        Method privateMethodWithParameter = addressClass.getDeclaredMethod("privateMethodWithParameter", String.class);
        privateMethodWithParameter.setAccessible(true);
        System.out.println(privateMethodWithParameter.invoke(null, "parameter"));
    }
}
