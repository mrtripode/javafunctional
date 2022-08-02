package es.mikostrategy.optionals;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyOptional {

    private static final Logger LOG = LogManager.getLogger(MyOptional.class);

    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello!")
            .orElseGet(() -> "Default value");
            LOG.info(value);

        Optional.ofNullable("fernanda@gmai.com");

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> LOG.info("Sending email to " + email),
                        () -> LOG.info("Cannot send email"));
    }

}
