package es.mikostrategy.withcombinatorpattern.normal;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isNameValid(String name) {
        return name.length() < 20;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+34");
    }

    private boolean isAdult(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Customer customer) {
        return isNameValid(customer.getName())
            && isEmailValid(customer.getEmail())
            && isPhoneNumberValid(customer.getPhoneNumber())
            && isAdult(customer.getDateOfBirth());
    }

}
