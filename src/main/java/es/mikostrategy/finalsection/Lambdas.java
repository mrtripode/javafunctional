package es.mikostrategy.finalsection;

import java.text.MessageFormat;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Lambdas {

    private static final Logger log = LogManager.getLogger(Lambdas.class);

    public static void main(String[] args) {
        String name = "John Doe";
        int age = 36;

        log.info(upperCaseName.apply(name));
        log.info(upperCaseName2.apply(name));
        log.info(upperCaseName3.apply(name));
        log.info(upperCaseName4.apply(name, age));
    }

    static Function<String, String> upperCaseName = name -> name.toUpperCase();

    static Function<String, String> upperCaseName2 = String::toUpperCase;

    static Function<String, String> upperCaseName3 = name -> {
        if (name.isBlank()) { throw new IllegalArgumentException(); }
        return name.toUpperCase();
    };

    static BiFunction<String, Integer, String> upperCaseName4 = (name, age) -> {
        if (name.isBlank()) { throw new IllegalArgumentException(); }
        return MessageFormat.format("Mr. {0} is {1} years", name.toUpperCase(), age);
    };

}
