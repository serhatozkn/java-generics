package tr.com.serhat.generics.rectangle;

public class Rectangle<T> {
    private T width;
    private T height;

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
