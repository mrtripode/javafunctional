package es.mikostrategy.finalsection;

import java.text.MessageFormat;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lambdas {

    private static final Logger LOG = LogManager.getLogger(Lambdas.class);

    public static void main(String[] args) {
        String name = "John Doe";
        int age = 36;

        LOG.info(">> Test 1");
        LOG.info(upperCaseName.apply(name));
        LOG.info(">> Test 2");
        LOG.info(upperCaseName2.apply(name));
        LOG.info(">> Test 3");
        LOG.info(upperCaseName3.apply(name));
        LOG.info(">> Test 4");
        LOG.info(upperCaseName4.apply(name, age));
    }

    protected static Function<String, CharSequence> upperCaseName = String::toUpperCase;

    protected static Function<String, CharSequence> upperCaseName2 = String::toUpperCase;

    protected static Function<String, CharSequence> upperCaseName3 = name -> {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
        return name.toUpperCase();
    };

    protected static BiFunction<String, Integer, CharSequence> upperCaseName4 = (name, age) -> {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
        return MessageFormat.format("Mr. {0} is {1} years old", name.toUpperCase(), age);
    };

}
