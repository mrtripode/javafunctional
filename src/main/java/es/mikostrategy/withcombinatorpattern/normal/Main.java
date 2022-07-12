package es.mikostrategy.withcombinatorpattern.normal;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
            "Alice",
            "alice@gmail.com",
            "+34990399934",
            LocalDate.of(2005, 1, 21));

        System.out.println(new CustomerValidatorService().isValid(customer));
    }
}
