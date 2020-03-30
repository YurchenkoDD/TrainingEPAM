package yurchenko.creational.factory;

public class BusFactory implements Vehicle {
    @Override
    public void produce(){
        System.out.println("Bus is created!");
    }
}
