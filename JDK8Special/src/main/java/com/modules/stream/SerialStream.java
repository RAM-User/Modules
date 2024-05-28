package com.modules.stream;

import com.modules.pojo.Person;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerialStream {

    private final static List<Person> PERSON_LIST = List.of(
            new Person("Neo", 22, "male"),
            new Person("Stan", 11, "female"),
            new Person("Grace", 34, "female"),
            new Person("Alex", 50, "male"),
            new Person("Sebastian", 8, "male")
    );

    @Test
    public void createStream() {
        // 所有实现 Collection接口
        Stream<Person> stream = PERSON_LIST.stream();

        

    }

}
