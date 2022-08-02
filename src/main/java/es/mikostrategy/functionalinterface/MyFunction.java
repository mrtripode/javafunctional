package es.mikostrategy.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyFunction {

    private static final Logger LOG = LogManager.getLogger(MyFunction.class);

    public static void main(String[] args) {
        LOG.info(">> Function example: takes 1 args and return one value");
        LOG.info(incrementOne(23));
        LOG.info(incrementOneFunction.apply(23));
        LOG.info(multiplyByTenFunction.apply(5));
        LOG.info(incrementOneAndThenMultiplyByTen.apply(8));

        LOG.info(">> BiFunction example: takes 2 values and return one value");
        LOG.info(incrementByOneAndThenMultiply(3, 100));
        LOG.info(incrementByOneAndThenMultiplyBiFunction.apply(3, 100));
    }

    // Normal Java function
    private static int incrementOne(final int number) {
        return number + 1;
    }

    // Functional Java Function
    // We added operator static to let use it into main method
    private static Function<Integer, Integer> incrementOneFunction = number -> ++number;

    private static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;

    private static Function<Integer, Integer> incrementOneAndThenMultiplyByTen = incrementOneFunction.andThen(multiplyByTenFunction);

    private static int incrementByOneAndThenMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }

    private static BiFunction<Integer, Integer, Integer> incrementByOneAndThenMultiplyBiFunction = (number, numToMultiplyBy) -> (number + 1) * numToMultiplyBy;

}