package yurchenko.deadlock.problem;

public class Counter{
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue() {
        value++;
    }
}