package es.mikostrategy.functionalinterface;

import java.text.MessageFormat;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyConsumer {

    private static final Logger LOG = LogManager.getLogger(MyConsumer.class);
    private static final String HELLO_0_THANKS_FOR_REGISTERING_PHONE_NUMBER_1 = "Hello {0}, thanks for registering phone number \"{1}\"";
    private static final String PHONE_NUMBER_HIDDEN = "***********";

    public static void main(String[] args) {
        Customer john = new Customer("John", "+34911110011");

        LOG.info(">> Normal Java function");
        greetCustomer(john);
        greetCustomerV2(john, false);

        LOG.info(">> Consumer Functional interface");
        greetCustomerConsumer.accept(john);
        greetCustomerConsumerV2.accept(john, false);
    }

    protected static void greetCustomer(Customer customer) {
        final String msg = MessageFormat.format(HELLO_0_THANKS_FOR_REGISTERING_PHONE_NUMBER_1,
                customer.custmerName, customer.custmerPhoneNumber);
        LOG.info(msg);
    }

    protected static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        final String msg = MessageFormat.format(HELLO_0_THANKS_FOR_REGISTERING_PHONE_NUMBER_1,
                customer.custmerName, (Boolean.TRUE.equals(showPhoneNumber) ? customer.custmerPhoneNumber : PHONE_NUMBER_HIDDEN));
        LOG.info(msg);
    }

    protected static Consumer<Customer> greetCustomerConsumer = customer -> {
        final String msg = MessageFormat.format(HELLO_0_THANKS_FOR_REGISTERING_PHONE_NUMBER_1,
                customer.custmerName, customer.custmerPhoneNumber);
        LOG.info(msg);
    };

    protected static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> {
        final String msg = MessageFormat.format(HELLO_0_THANKS_FOR_REGISTERING_PHONE_NUMBER_1,
                customer.custmerName, (Boolean.TRUE.equals(showPhoneNumber) ? customer.custmerPhoneNumber : PHONE_NUMBER_HIDDEN));
        LOG.info(msg);
    };

    protected static record Customer(String custmerName, String custmerPhoneNumber) { }

}
