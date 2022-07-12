package es.mikostrategy.withcombinatorpattern.combining;

import static es.mikostrategy.withcombinatorpattern.combining.CustomerRegistrationValidator.isNameValid;

import java.time.LocalDate;

import es.mikostrategy.withcombinatorpattern.combining.CustomerRegistrationValidator.ValidationResult;

public class Main {

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

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalArgumentException(result.name());
        }
    }

}
