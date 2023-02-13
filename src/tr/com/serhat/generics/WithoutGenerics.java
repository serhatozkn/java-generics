package tr.com.serhat.generics;

import java.util.ArrayList;
import java.util.List;

public class WithoutGenerics {

    public static void main(final String[] args) {

        final List aList = new ArrayList();

        aList.add("test1");
        aList.add("test2");

        final String valIdx0 = (String) aList.get(0);
        final String valIdx1 = (String) aList.get(1);

        System.out.println("Idx0 : " + valIdx0);
        System.out.println("Idx1 : " + valIdx1);

        // As you see without generics we had to do type casts
        // And erroneous type casts can only be detected at runtimes
        // as you see at next part. It would be easier if it was detected at compile
        // time by use of generics

        aList.add(3); // Not an compile time error without. This line wouldn't have compiled if we have declared as List<String>
        final String valIdx3 = (String)aList.get(2); // This line will throw class cast exception
    }
}
