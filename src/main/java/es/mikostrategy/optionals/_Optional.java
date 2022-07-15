package es.mikostrategy.optionals;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class _Optional {

     private static final Logger log = LogManager.getLogger(_Optional.class);

    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello!")
            .orElseGet(() -> "Default value");
            log.info(value);

        // Optional.ofNullable("fernanda@gmai.com")
         Optional.ofNullable(null)
            .ifPresentOrElse(
                email -> log.info("Sending email to " + email),
                () -> log.info("Cannot send email"));



    }
}
