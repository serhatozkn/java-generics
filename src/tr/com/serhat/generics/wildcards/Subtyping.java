package tr.com.serhat.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Subtyping {

    public void demo() {
        List<Integer> integerList = new ArrayList<>();
        List<? extends Integer> extendsIntList = integerList;
        List<? extends Number> extendsNumList = extendsIntList;
        List<?> objList = extendsNumList;

        // List<? extends Integer> is child of List<? extends Number>
        // If B extends A
        // Class<? extends B> is child of Class<? extends A>
    }
}
