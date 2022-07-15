package es.mikostrategy.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class _Function {

    private static final Logger log = LogManager.getLogger(_Function.class);

    public static void main(String[] args) {
        // Function example: takes 1 args and return one value
        int inc = incrementByOne(1);
        log.info(inc);

        int inc2  = incrementByOneFunction.apply(1);
        log.info(inc2);

        int multiply = multiplyBy10Function.apply(2);
        log.info(multiply);

        int incrBy1AndThenMultiplyBy10 = addBy1AndThenMultiplyBy10.apply(4);
        log.info(incrBy1AndThenMultiplyBy10);

        // BiFunction example: takes 2 values and return one value
        log.info(incrementByOneAndThenMultiply(4, 10));
        log.info(incrementByOneAndThenMultiplyBiFunction.apply(4, 10));
    }

    // Normal Java function
    private static int incrementByOne(final int number) {
        return number + 1;
    }

    // Functional Java Function
    // We added operator static to let use it into main method
    private static Function<Integer, Integer> incrementByOneFunction = number -> ++number;

    private static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    private static Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);


    private static int incrementByOneAndThenMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }

    private static BiFunction<Integer, Integer, Integer> incrementByOneAndThenMultiplyBiFunction = (number, numToMultiplyBy) -> (number + 1) * numToMultiplyBy;

}