package yurchenko.deadlock.problem;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        new Thread(service.block1).start();
        new Thread(service.block2).start();
    }
}
