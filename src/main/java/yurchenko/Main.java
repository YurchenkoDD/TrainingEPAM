package yurchenko;

import yurchenko.logic.EntityCheck;
import yurchenko.logic.FileEntityWrapper;

public class Main {
    private static final String CLASSPATH = "yurchenko.entity.Human";
    private static final String PATH = "src/main/resources/humanValues.txt";

    public static void main(String[] args) {
        EntityCheck checker = new EntityCheck();
        Class<?> clazz = checker.loadClass(CLASSPATH);
        checker.checkValueAnnotation(clazz);
        checker.insertValueInFields(clazz);

        FileEntityWrapper fileHandler = new FileEntityWrapper();
        fileHandler.searchClassesWithAnnotation();
        fileHandler.setPeopleValues(PATH);
    }
}