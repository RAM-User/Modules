package com.chapter15;

class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee{}

class Employee2{
    public Employee2(Integer x) {
        System.out.println(x);
    }
}
public class InstantiateGenericType {
    public static void main(String[] args) {
        // 有默认无参构造器
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println(Boolean.TRUE);

        try {
            // 无默认无参构造器
            ClassAsFactory<Employee2> f2 = new ClassAsFactory<>(Employee2.class);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // Integer无默认构造器
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Boolean.FALSE);
        }
    }
}
