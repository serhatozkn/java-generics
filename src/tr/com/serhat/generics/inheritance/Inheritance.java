package tr.com.serhat.generics.inheritance;

import tr.com.serhat.generics.rectangle.Rectangle;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Inheritance {

    // Don't forget that Rectangle<Integer> isn't a subtype of Rectangle<Number>
    // even-though Integer is subtype of class Number
    // The only relation between Rectangle<Integer> and Rectangle<Number> is that;
    // both classes parent is class Object.
    
    public static Number diagonalLengthOf(final Rectangle<Number> rectangle) {
        final double w = rectangle.getWidth().doubleValue();
        final double h = rectangle.getHeight().doubleValue();
        return Math.sqrt(w*w + h*h);
    }

    public static int sum(final Collection<Integer> aCollection) {
        return aCollection.stream().mapToInt(x -> x).sum();
    }
    
    public static void main(final String[] args) {
        final Rectangle<Number> rectangle = new Rectangle<>();
        rectangle.setHeight(5);
        rectangle.setWidth(12);
        System.out.println("Diagonal of rectangle is: " + diagonalLengthOf(rectangle));

        // Integer is subclass of abstract class number
        final Rectangle<Integer> rectangleInt = new Rectangle<>();
        rectangle.setWidth(6);
        rectangle.setHeight(8);

        //****************************************************************
        // diagonalLengthOf(rectangleInt);
        // The code line above will result to a compile time error
        // since Rectangle<Integer> is not subclass of Rectangle<Number>.
        //*****************************************************************

        // List<Integer> is subclass of Collection<Integer> -> Since the generic types are same
        final List<Integer> aList = List.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Sum of list is: : "+ sum(aList));
    }
}
