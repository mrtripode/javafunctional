package es.mikostrategy.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlsSupplier.get());
    }

    protected static String getDBConnectionUrl() {
        return "jdbc://localhosy:5432/users";
    }

    protected static Supplier<String> getDBConnectionUrlSupplier = ()
        -> "jdbc://localhosy:5432/users";

    protected static Supplier<List<String>> getDBConnectionUrlsSupplier = ()
        -> List.of("jdbc://localhosy:5432/users", "jdbc://localhosy:5432/customers");

}
