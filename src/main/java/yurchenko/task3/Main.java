package yurchenko.task3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        // Path specified for Unix based systems
        CustomClassLoader classLoader = new CustomClassLoader("/home/dd/workflowLocal/");
        Class<?> clazz;
        try {
            clazz = classLoader.loadClass("TestClass");
            log.info("Loaded " + clazz.getName() + ".class");
            Object obj = clazz.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            log.error(e.getMessage());
        }
    }
}