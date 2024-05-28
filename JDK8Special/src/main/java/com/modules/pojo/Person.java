package com.modules.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * @author moai
 */
@Data
@AllArgsConstructor
public class Person {
    //private Long id;

    private String name;

    //private String mobile;

    private Integer age;

    private String sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }
}
