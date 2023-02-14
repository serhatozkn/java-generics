package tr.com.serhat.generics.rawtypes;

import tr.com.serhat.generics.rectangle.Rectangle;

public class RawTypes {

    // Note: Raw types are allowed for backward compatibility
    public static void main(final String[] args) {

        // This is raw type of rectangle class
        // The type parameter is defined as Object by default
        // Same with Rectangle<Object> rectangle = new Rectangle<>();
        Rectangle rectangle = new Rectangle();

    }
}
