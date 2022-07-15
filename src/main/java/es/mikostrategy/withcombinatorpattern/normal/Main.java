package es.mikostrategy.withcombinatorpattern.normal;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Customer customer = new Customer(
            "Alice",
            "alice@gmail.com",
            "+34990399934",
            LocalDate.of(2005, 1, 21));

        log.info(new CustomerValidatorService().isValid(customer));
    }
}
