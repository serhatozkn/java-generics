package tr.com.serhat.generics.rectangle;

// Note: There can be multiple bounds
// Like: public class BoundedRectangle<T extends Number & Comparable>
public class BoundedRectangle<T extends Number> {

    // Note: The extends at type parameter means either implements or extends

    private T width;
    private T height;

    @Override
    public String toString() {
        return "My width is : " + getWidth() + ", and height is: " + getHeight();
    }

    // For demonstration (not a sensible function)
    // -> we can call functions of Number function ( T -> Number )
    public double doubleArea() {
        return width.doubleValue() * height.doubleValue();
    }

    public static void main(final String[] args) {
        // Now raw type is not object, its Number
        // Not correct usage just to test what happens
        final BoundedRectangle boundedRectangle = new BoundedRectangle();
        boundedRectangle.setWidth(3);
        boundedRectangle.setHeight(3.5);

        //boundedRectangle.setHeight("abc"); -> compile-time error
        System.out.println(boundedRectangle);

        final BoundedRectangle<Integer> intRectangle = new BoundedRectangle<>();
        // intRectangle.setHeight(3.5d); -> Compile timer error
        intRectangle.setWidth(4);
        intRectangle.setHeight(3);
        System.out.println(intRectangle);
    }

    public T getWidth() {
        return width;
    }

    public void setWidth(T width) {
        this.width = width;
    }

    public T getHeight() {
        return height;
    }

    public void setHeight(T height) {
        this.height = height;
    }
}