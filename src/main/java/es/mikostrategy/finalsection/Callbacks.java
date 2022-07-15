package es.mikostrategy.finalsection;

import static java.text.MessageFormat.format;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Callbacks {

    private static final Logger log = LogManager.getLogger(Callbacks.class);

    public static void main(String[] args) {
        //hello("John", "Doe", value -> {
        hello("John", null, value -> {
            log.info(format("Error: No 'lastName' provider for {0}.", value));
        });

        hello2("John", null, () -> {
            log.info("Error: No 'lastName' provider.");
        });
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        log.info(format("Hello {0}!", firstName));

        if (lastName != null) {
            log.info(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        log.info(format("Hello {0}!", firstName));

        if (lastName != null) {
            log.info(lastName);
        } else {
            callback.run();
        }
    }

}
