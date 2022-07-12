package es.mikostrategy.optionals;

import java.util.Optional;

public class _Optional {
    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello!")
            .orElseGet(() -> "Default value");
        System.out.println(value);

        // Optional.ofNullable("fernanda@gmai.com")
         Optional.ofNullable(null)
            .ifPresentOrElse(
                email -> System.out.println("Sending email to " + email),
                () -> System.out.println("Cannot send email"));



    }
}
