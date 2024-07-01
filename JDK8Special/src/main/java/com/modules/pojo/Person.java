package com.modules.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author moai
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    //private Long id;

    private String name;

    //private String mobile;

    private Integer age;

    private String sex;

}
