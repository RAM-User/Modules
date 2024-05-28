package com.modules.stream;

import com.modules.pojo.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerialStream {

    // foreach map filter limit sorted
    private final List<Person> PERSON_LIST = List.of(
            new Person("Neo", 22, "male"),
            new Person("Stan", 11, "female"),
            new Person("Grace", 34, "female"),
            new Person("Alex", 50, "male"),
            new Person("Sebastian", 8, "male"),
            new Person("Sebastian", 8, "male"),
            new Person("Grace", 34, "female")
    );

    @Test
    public void createStream() {
        // 所有实现 Collection接口
        Stream<Person> stream = PERSON_LIST.stream();

        Stream.Builder<Person> personBuilder = Stream.builder();
    }

    @Test
    public void  filteringSlicing() {
        // filter distinct limit skip
        PERSON_LIST.stream()
                .filter(person -> person.getAge() > 18)
                .distinct()
                .limit(5)
                .skip(1)
                .forEach(System.out::println);

    }

    @Test
    public void mapping() {
        // 映射结果
        Stream<String> nameString = PERSON_LIST.stream().map(Person::getName);
        nameString.forEach(System.out::println);
    }

    @Test
    public void  sorting() {
        List<Person> personList = List.of(
                new Person("Neo", 22, "male"),
                new Person("Stan", 11, "female"),
                new Person("Grace", 34, "female"),
                new Person("Alex", 50, "male"),
                new Person("Sebastian", 8, "male"),
                new Person("Sebastian", 8, "male"),
                new Person("Grace", 34, "female")
        );
        List<Integer> ageList = personList.stream().map(Person::getAge).collect(Collectors.toList());
        ageList.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void aggregation() {
        // count max min average sum
        long count = PERSON_LIST.stream().count();
        Optional<Person> max = PERSON_LIST.stream().max(Comparator.comparingInt(Person::getAge));

    }
}
