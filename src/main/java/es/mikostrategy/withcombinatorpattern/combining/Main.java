package es.mikostrategy.withcombinatorpattern.combining;

import static es.mikostrategy.withcombinatorpattern.combining.CustomerRegistrationValidator.isNameValid;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.mikostrategy.withcombinatorpattern.combining.CustomerRegistrationValidator.ValidationResult;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Customer customer = new Customer(
            "Alice",
            "alice@gmail.com",
            "+34990399934",
            LocalDate.of(2006, 1, 21));

        // Using combination pattern
        ValidationResult result = isNameValid()
                .and(CustomerRegistrationValidator.isEmailValid())
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(customer);

        log.info(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalArgumentException(result.name());
        }
    }

}
