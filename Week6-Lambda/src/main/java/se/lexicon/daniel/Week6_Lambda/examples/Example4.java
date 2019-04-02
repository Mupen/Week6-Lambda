package se.lexicon.daniel.Week6_Lambda.examples;

import java.util.Arrays;
import java.util.List;

public class Example4 {
    public static void main(String[] args) {


        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));


        persons
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(person -> System.out.println(person));    // Pamela
    }


}