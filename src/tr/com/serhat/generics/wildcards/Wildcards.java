package tr.com.serhat.generics.wildcards;

import tr.com.serhat.generics.rectangle.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Wildcards {

    public void demoLowerBounded() {
        final List<Object> objList = new ArrayList<>();
        fillList(objList, 5, 20);
        //fillList2(objList, 5, 20); -> compile time error List<Int> is not subtype of List<Obj>
        String listAsText = objList.stream().map(e -> e.toString()).collect(Collectors.joining("-"));
        System.out.println(listAsText);
    }

    public void demoUpperBounded() {
        final Rectangle<Number> nRectangle = new Rectangle<>();
        nRectangle.setHeight(5f);
        nRectangle.setWidth(6f);

        final Rectangle<Double> dRectangle = new Rectangle<>();
        dRectangle.setHeight(5d);
        dRectangle.setWidth(15d);

        final Rectangle<Integer> iRectangle = new Rectangle<>();
        iRectangle.setHeight(12);
        iRectangle.setWidth(23);

        System.out.println("Circumference of 1 : " + circumferenceOf(nRectangle));
        System.out.println("Circumference of 2 : " + circumferenceOf(dRectangle));
        System.out.println("Circumference of 3 : " + circumferenceOf(iRectangle));

        final List<? extends Number> numberUB = new ArrayList<>();
        // numberUB.add(new Double(3d)); -> compile time error only null can be inserted
        // numberUB.add(3); -> compile time error only null can be inserted
        numberUB.add(null);

    }

    public void demoUnBoundedWildcards() {
        // Useful when:
        // If you are writing a method that can be implemented using functionality provided in the Object class.
        // When the code is using methods in the generic class that don't depend on the type parameter.
        // For example, List.size or List.clear.
        // In fact, Class<?> is so often used because most of the methods in Class<T> do not depend on T.

        final List<Integer> integers = List.of(2, 3, 5, 7, 11, 13, 17, 19);
        final List<String> strings = List.of("2", "3", "5", "7", "11", "13", "17", "19");

        //printList(strings); --> compile timer error
        printListGeneric(strings);
        printListGeneric(integers);

        List<?> wildCardList = new ArrayList<>();
        wildCardList.add(null);
        //wildCardList.add(new Object()); -> compile time error only null can be inserted into list of ?
        //wildCardList.add(1);
    }

    private void fillList(final List<? super Integer> aList, final int begin, final int end) {
        IntStream.rangeClosed(begin, end).forEach(e -> aList.add(e));
    }

    private void fillList2(final List<Integer> aList, final int begin, final int end) {
        IntStream.rangeClosed(begin, end).forEach(e -> aList.add(e));
    }

    // ? extends Sth is named as upper-bounded wildcards
    private Number circumferenceOf(final Rectangle<? extends Number> rectangle) {
        return 2 * (rectangle.getWidth().doubleValue() + rectangle.getHeight().doubleValue());
    }

    // What is the flaw of this method?
    // It can not print a List<Integer>, List<String> etc.
    // Instead of this use List<?>
    public void printList(final List<Object> list) {
        list.stream().forEach(System.out::println);
    }

    public void printListGeneric(final List<?> list) {
        list.stream().forEach(System.out::println);
    }

    public static void main(final String[] args) {
        final Wildcards wildcards = new Wildcards();
        wildcards.demoUpperBounded();
        wildcards.demoUnBoundedWildcards();
        wildcards.demoLowerBounded();
    }
}
