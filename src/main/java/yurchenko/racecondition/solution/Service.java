package yurchenko.racecondition.solution;

public class Service implements Runnable {
    @Override
    public void run() {
        Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            counter.incrementedValue();
            counter.getValue();
        }
    }
}
