package es.mikostrategy.functionalinterface;

import java.util.function.Consumer;
import java.util.function.BiConsumer;

public class _Consumer {

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
        System.out.println("Hello "
                 + customer.custmerName
                 + ", thanks for registering phone number \""
                 + customer.custmerPhoneNumber
                  + "\"");
    }

    protected static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello "
                 + customer.custmerName
                 + ", thanks for registering phone number \""
                 + (Boolean.TRUE.equals(showPhoneNumber) ? customer.custmerPhoneNumber : "*****")
                 + "\""
        );
    }

    protected static Consumer<Customer> greetCustomerConsumer = customer -> {
        System.out.println("Hello "
            + customer.custmerName
            + ", thanks for registering phone number \""
            + customer.custmerPhoneNumber
            + "\""
        );
    };

    protected static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> {
        System.out.println("Hello "
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
