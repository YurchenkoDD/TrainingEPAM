package yurchenko.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple class to demonstrate OutOfMemoryError
 * Error will be caused by heap overload with string instances
 */

public class Main {
    /**
     * You need set JVM -Xmx20m for this example work
     */
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            stringList.add("string");
        }
    }
}