package es.mikostrategy.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MySupplier {

    private static final String JDBC_LOCALHOST_URL = "jdbc://localhosy:5432/users";
    private static final Logger LOG = LogManager.getLogger(MySupplier.class);

    public static void main(String[] args) {
        LOG.info(getDBConnectionUrl());
        LOG.info(getDBConnectionUrlSupplier.get());
        LOG.info(getDBConnectionUrlsSupplier.get());
    }

    protected static String getDBConnectionUrl() {
        return JDBC_LOCALHOST_URL;
    }

    protected static Supplier<String> getDBConnectionUrlSupplier = ()
        -> JDBC_LOCALHOST_URL;

    protected static Supplier<List<String>> getDBConnectionUrlsSupplier = ()
        -> List.of(JDBC_LOCALHOST_URL, "jdbc://localhosy:5432/customers");

}
