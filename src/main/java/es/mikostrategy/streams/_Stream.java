package es.mikostrategy.streams;

import java.util.List;
import java.util.stream.Collectors;

import static es.mikostrategy.streams._Stream.Gender.FEMALE;
import static es.mikostrategy.streams._Stream.Gender.MALE;

public class _Stream {
   
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
        );

        people.stream()
            .map(p -> p.gender)
            .collect(Collectors.toSet())
            .forEach(System.out::println);

        people.stream()
            .map(p -> p.name)
            .mapToInt(String::length)
            .forEach(System.out::println);

        boolean onlyFemalePeople = people.stream()
            .allMatch(p -> FEMALE.equals(p.gender));

        boolean onlyFemalePeopleV2 = people.stream()
            .noneMatch(p -> FEMALE.equals(p.gender));

        System.out.println(onlyFemalePeople);
        System.out.println(onlyFemalePeopleV2);
    }

    private static class Person {

        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person[name: " + name + ", gender: "  + gender + "]";
        }   

    }
    
    protected enum Gender {
        MALE, FEMALE;
    } 

}
