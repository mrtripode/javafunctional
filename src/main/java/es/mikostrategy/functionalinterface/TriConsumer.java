package es.mikostrategy.functionalinterface;

@FunctionalInterface
public interface TriConsumer<T, V, U> {

    public void apply(T t, V v, U u);

    public default TriConsumer<T, V, U> andThen(TriConsumer<? super T, ? super V, ? super U> after) {
        return null;
    }

}