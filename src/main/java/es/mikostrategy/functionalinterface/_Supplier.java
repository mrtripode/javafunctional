package es.mikostrategy.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class _Supplier {

    private static final Logger log = LogManager.getLogger(_Supplier.class);

    public static void main(String[] args) {
        log.info(getDBConnectionUrl());
        log.info(getDBConnectionUrlSupplier.get());
        log.info(getDBConnectionUrlsSupplier.get());
    }

    protected static String getDBConnectionUrl() {
        return "jdbc://localhosy:5432/users";
    }

    protected static Supplier<String> getDBConnectionUrlSupplier = ()
        -> "jdbc://localhosy:5432/users";

    protected static Supplier<List<String>> getDBConnectionUrlsSupplier = ()
        -> List.of("jdbc://localhosy:5432/users", "jdbc://localhosy:5432/customers");

}
