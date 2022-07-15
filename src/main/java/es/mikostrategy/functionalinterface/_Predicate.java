package es.mikostrategy.functionalinterface;

import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class _Predicate {

    private static final Logger log = LogManager.getLogger(_Predicate.class);

    public static void main(String[] args) {
        log.info("Normal Java function");
        log.info(isPhoneNumberValid("07000000000"));
        log.info(isPhoneNumberValid("0700000000"));
        log.info(isPhoneNumberValid("09009877300"));

        log.info("Predicate Functional function");
        log.info(isPhoneNumberValidPredicate.test("07000000000"));
        log.info(isPhoneNumberValidPredicate.test("0700000000"));
        log.info(isPhoneNumberValidPredicate.test("09009877300"));

        log.info(
            "Is phone number valid and contains number 3 = "
            + isPhoneNumberValidPredicate.and(containsNumber3).test("09009877300")
        );

        log.info(
            "Is phone number valid and contains number 3 = "
            + isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003")
        );

        log.info(
            "Is phone number valid or contains number 3 = "
            + isPhoneNumberValidPredicate.or(containsNumber3).test("07000000000")
        );
    }    

    protected static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    protected static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
        phoneNumber.startsWith("07") && phoneNumber.length() == 11;            

    protected static Predicate<String> containsNumber3 = phoneNumber ->
        phoneNumber.contains("3");



}
