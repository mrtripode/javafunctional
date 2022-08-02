package es.mikostrategy.finalsection;

import static java.text.MessageFormat.format;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Callbacks {

    private static final Logger LOG = LogManager.getLogger(Callbacks.class);

    public static void main(String[] args) {
        LOG.info(">> Test 1");
        greated("Javier", null, value -> {
            final String msg = format("Error: No 'lastName' provider for {0}.", value);
            LOG.info(msg);
        });

        LOG.info(">> Test 2");
        greated("Javier", "Gomez", value -> {
            final String msg = format("Error: No 'lastName' provider for {0}.", value);
            LOG.info(msg);
        });

        LOG.info(">> Test 3");
        greatedV2("Anastasiia", null, () -> {
            final String msg = "Error: No 'lastName' provider.";
            LOG.info(msg);
        });

        LOG.info(">> Test 4");
        greatedV2("Anastasiia", "Varlivcok", () -> {
            final String msg = "Error: No 'lastName' provider.";
            LOG.info(msg);
        });
    }

    protected static void greated(String firstName, String lastName, Consumer<String> callback) {
        final String msg = format("Hello {0}!", firstName);
        LOG.info(msg);

        if (lastName != null) {
            final String msgFullName = format("Your full name is: {0} {1}", firstName, lastName);
            LOG.info(msgFullName);
        } else {
            callback.accept(firstName);
        }
    }

    protected static void greatedV2(String firstName, String lastName, Runnable callback) {
        final String msg = format("Hello {0}!", firstName);
        LOG.info(msg);

        if (lastName != null) {
            final String msgFullName = format("Your full name is: {0} {1}", firstName, lastName);
            LOG.info(msgFullName);
        } else {
            callback.run();
        }
    }

}
