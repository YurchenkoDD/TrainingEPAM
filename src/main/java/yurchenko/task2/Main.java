package yurchenko.task2;

/**
 * Simple class to demonstrate StackOverflowError
 * That error will causes by calling
 * recursive method that overflow the stack
 */

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        recursion(counter);
    }

    private static void recursion(int counter) {
        recursion(counter++);
    }
}