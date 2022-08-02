package es.mikostrategy.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import static es.mikostrategy.imperative.Main.Gender.FEMALE;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);
    
    public static void main( String[] args ) {
        List<Person> people = List.of(
            new Person("Andres", Gender.MALE),
            new Person("Marta", Gender.FEMALE),
            new Person("Teresa", Gender.FEMALE),
            new Person("Javier", Gender.MALE),
            new Person("Julia", Gender.FEMALE)
        );

        LOG.info(">> Imperative approach");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        LOG.debug(females);
        for (Person female : females) {
            LOG.info(female);
        }

        LOG.info(">> Declarative approach");
        Predicate<Person> pPerson = person -> FEMALE.equals(person.gender);
        people.stream()
                .filter(pPerson)
                .map(person -> person.name)
                .forEach(LOG::info);

        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(LOG::info);

        Function<Person, Void> printName = person -> {
            LOG.info(person.name);
            return null;
        };

        LOG.info(">> Lambda approach");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(printName::apply);
    
        LOG.info(">> Reference approach");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(printName::apply);
    }

    private static record Person(String name, Gender gender) {

        @Override
        public String toString() {
            return "Person[name: " + name + ", gender: "  + gender + "]";
        }   

    }

    enum Gender {
        MALE, FEMALE;
    }

}
