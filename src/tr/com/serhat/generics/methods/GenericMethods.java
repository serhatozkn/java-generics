package tr.com.serhat.generics.methods;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class GenericMethods {

    public static void main(final String[] args) {
        final Integer[] integerArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Value less then 5 is " + countLessThan(integerArray, 5));

        final Double[] doubleArray = DoubleStream.generate(() -> Math.random() * 1_000)
                .limit(150)
                .boxed()
                .toList()
                .toArray(new Double[0]);


        System.out.println("Value less than 100d is " + countLessThan(doubleArray, 100d));
    }

    public static <T extends Comparable> int countLessThan(T[] array, T bound) {
        return (int) Arrays.stream(array)
                .filter(e -> e.compareTo(bound) < 0)
                .count();
    }
}
