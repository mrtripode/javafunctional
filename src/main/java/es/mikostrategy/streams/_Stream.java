package es.mikostrategy.streams;

import static es.mikostrategy.streams._Stream.Gender.FEMALE;
import static es.mikostrategy.streams._Stream.Gender.MALE;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class _Stream {

    private static final Logger log = LogManager.getLogger(_Stream.class);
   
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

        log.info(onlyFemalePeople);
        log.info(onlyFemalePeopleV2);
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
