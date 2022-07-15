package es.mikostrategy.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class _Consumer {

    private static final Logger log = LogManager.getLogger(_Consumer.class);

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "99999");
        // Normal Java function
        greetCustomer(maria);
        greetCustomerV2(maria, false);

        // Consumer Functional interface
        greetCustomerConsumer.accept(maria);
        greetCustomerConsumerV2.accept(maria, false);
    }

    protected static void greetCustomer(Customer customer) {
        log.info("Hello "
                 + customer.custmerName
                 + ", thanks for registering phone number \""
                 + customer.custmerPhoneNumber
                  + "\"");
    }

    protected static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        log.info("Hello "
                 + customer.custmerName
                 + ", thanks for registering phone number \""
                 + (Boolean.TRUE.equals(showPhoneNumber) ? customer.custmerPhoneNumber : "*****")
                 + "\""
        );
    }

    protected static Consumer<Customer> greetCustomerConsumer = customer -> {
        log.info("Hello "
            + customer.custmerName
            + ", thanks for registering phone number \""
            + customer.custmerPhoneNumber
            + "\""
        );
    };

    protected static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> {
        log.info("Hello "
            + customer.custmerName
            + ", thanks for registering phone number \""
            + (Boolean.TRUE.equals(showPhoneNumber) ? customer.custmerPhoneNumber : "*****")
            + "\""
        );
    };

    protected static class Customer  {

        private final String custmerName;
        private final String custmerPhoneNumber;

        public Customer(String custmerName, String custmerPhoneNumber) {
            this.custmerName = custmerName;
            this.custmerPhoneNumber = custmerPhoneNumber;
        }

    }

}
