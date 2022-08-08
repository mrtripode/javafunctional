package es.mikostrategy.optionals;

import java.text.MessageFormat;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyOptional {

    private static final Logger LOG = LogManager.getLogger(MyOptional.class);

    public static void main(String[] args) {
        String mf = "Sending email to \"{0}\"";
        String ferEmail = "fernanda@gmai.com";

        LOG.info(">> Greats is present");
        Object value = Optional.ofNullable("Hello!")
                .orElseGet(() -> "Default value");
        LOG.info(value);

        LOG.info(">> Email is null");
        Optional.ofNullable(null)
                .ifPresentOrElse(email -> LOG.info(MessageFormat.format(mf, ferEmail)),
                        () -> LOG.info("Cannot send email"));

        LOG.info(">> Email not null");
        Optional.ofNullable(ferEmail)
                .ifPresentOrElse(email -> LOG.info(MessageFormat.format(mf, ferEmail)),
                () -> LOG.info("Cannot send email"));

        LOG.info(">> Email not null 2");
        final Optional<String> value2 = Optional.ofNullable(ferEmail);
        value2.ifPresent((t) -> LOG.info("Value is present"));
    }

}
