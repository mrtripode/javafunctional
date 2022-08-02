package es.mikostrategy.functionalinterface;

import java.text.MessageFormat;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyPredicate {

    private static final Logger LOG = LogManager.getLogger(MyPredicate.class);
    private static final String IS_PHONE_NUMBER_VALID_AND_CONTAINS_NUMBER_3 = "Is phone number valid and contains number 3 = {0}";
    private static final String NUM_07_000_000_000 = "07000000000";
    private static final String NUM_700_000_000 = "700000000";
    private static final String NUM_09_009_877_300 = "09009877300";

    public static void main(String[] args) {
        LOG.info("Normal Java function");
        LOG.info(isPhoneNumberValid(NUM_07_000_000_000));
        LOG.info(isPhoneNumberValid(NUM_700_000_000));
        LOG.info(isPhoneNumberValid(NUM_09_009_877_300));

        LOG.info("Predicate Functional function");
        LOG.info(isPhoneNumberValidPredicate.test(NUM_07_000_000_000));
        LOG.info(isPhoneNumberValidPredicate.test(NUM_700_000_000));
        LOG.info(isPhoneNumberValidPredicate.test(NUM_09_009_877_300));

        String msg1 = MessageFormat.format(IS_PHONE_NUMBER_VALID_AND_CONTAINS_NUMBER_3,
                isPhoneNumberValidPredicate.and(containsNumber3).test(NUM_09_009_877_300));
        LOG.info(msg1);

        String msg2 = MessageFormat.format(IS_PHONE_NUMBER_VALID_AND_CONTAINS_NUMBER_3,
                isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003"));
        LOG.info(msg2);

        String msg3 = MessageFormat.format("Is phone number valid or contains number 3 = {0}",
                isPhoneNumberValidPredicate.or(containsNumber3).test(NUM_07_000_000_000));
        LOG.info(msg3);
    }    

    protected static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    protected static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
        phoneNumber.startsWith("07") && phoneNumber.length() == 11;            

    protected static Predicate<String> containsNumber3 = phoneNumber ->
        phoneNumber.contains("3");

}
