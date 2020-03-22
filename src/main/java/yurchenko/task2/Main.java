package yurchenko.task2;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        recursion(counter);
    }

    private static void recursion(int counter) {
        recursion(counter++);
    }
}