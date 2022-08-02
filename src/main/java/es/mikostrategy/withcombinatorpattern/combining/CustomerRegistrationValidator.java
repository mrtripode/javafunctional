package es.mikostrategy.withcombinatorpattern.combining;

import static es.mikostrategy.withcombinatorpattern.combining.CustomerRegistrationValidator.ValidationResult.EMAIL_NOT_VALID;
import static es.mikostrategy.withcombinatorpattern.combining.CustomerRegistrationValidator.ValidationResult.IS_NOT_AND_ADULT;
import static es.mikostrategy.withcombinatorpattern.combining.CustomerRegistrationValidator.ValidationResult.PHONE_NUMBER_NOT_VALID;
import static es.mikostrategy.withcombinatorpattern.combining.CustomerRegistrationValidator.ValidationResult.SUCCESS;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import es.mikostrategy.withcombinatorpattern.combining.CustomerRegistrationValidator.ValidationResult;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {
    
    public static CustomerRegistrationValidator isNameValid() {
        return customer -> {
            if (customer.name().length() < 20) {
                return ValidationResult.SUCCESS;
            } else {
                return ValidationResult.NAME_NOT_VALID;
            }
        };
    }

    public static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.email().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }

    public static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.phoneNumber().startsWith("+34") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    public static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.dateOfBirth(), LocalDate.now()).getYears() > 16 ? SUCCESS : IS_NOT_AND_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        NAME_NOT_VALID,
        EMAIL_NOT_VALID,
        PHONE_NUMBER_NOT_VALID,
        IS_NOT_AND_ADULT;
    }

}
