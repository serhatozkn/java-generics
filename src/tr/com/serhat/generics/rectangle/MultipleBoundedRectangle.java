package tr.com.serhat.generics.rectangle;

// Classes must be declared before interface's at extends lists
// Since Number is an abstract class it must be declared before Comparable interface,
// Otherwise it will be a compile-time error.
public class MultipleBoundedRectangle <T extends Number & Comparable> {

    private final T area;

    public MultipleBoundedRectangle(T area) {
        this.area = area;
    }

    public int compareArea(MultipleBoundedRectangle<T> otherRectangle) {
        return area.compareTo(otherRectangle);
    }

    public static void main(final String[] args) {

        final MultipleBoundedRectangle<Integer> rect1 = new MultipleBoundedRectangle<>(5);
        final MultipleBoundedRectangle<Integer> rect2 = new MultipleBoundedRectangle<>(6);
        //MultipleBoundedRectangle<LongAccumulator> compileTimeError = new MultipleBoundedRectangle<>();
        int compareResult = rect1.compareArea(rect2);

    }
}
