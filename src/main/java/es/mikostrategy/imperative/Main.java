package es.mikostrategy.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import static es.mikostrategy.imperative.Main.Gender.FEMALE;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static Logger log = LogManager.getLogger(Main.class);
    
    public static void main( String[] args ) {
        List<Person> people = List.of(
            new Person("John", Gender.MALE),
            new Person("Maria", Gender.FEMALE),
            new Person("Aisha", Gender.FEMALE),
            new Person("Alex", Gender.MALE),
            new Person("Alice", Gender.FEMALE)
        );

        // Imperative approach
        log.debug("// Imperative approach");
        System.out.println("// Imperative approach");
        List<Person> females = new ArrayList<>();  

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        log.debug(females);
        for (Person female : females) {
            System.out.println(female);
        }

        // Declarative approach
        log.debug("// Declarative approach");
        System.out.println("// Declarative approach");
//        Predicate<Person> pPerson = person -> FEMALE.equals(person.gender);
//        people.stream()
//            .filter(pPerson)
//            .map(person -> person.name)
//            .forEach(System.out::println);

        people.stream()
            .filter(person -> FEMALE.equals(person.gender))
            .forEach(System.out::println);

        Function<Person, Void> printName = person -> {
            System.out.println(person.name);
            return null;
        };

        System.out.println("// Lambda approach");
        people.stream()
            .filter(person -> FEMALE.equals(person.gender))
            .forEach(person -> {
            printName.apply(person);
        });
    
        System.out.println("// Reference approach");
        people.stream()
        .filter(person -> FEMALE.equals(person.gender))
        .forEach(printName::apply);
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
    
    enum Gender {
        MALE, FEMALE;
    }

}
