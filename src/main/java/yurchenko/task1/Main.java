package yurchenko.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            stringList.add("string");
        }
    }
}