package yurchenko.creational.factory;

public class CarFactory implements Vehicle {
    @Override
    public void produce(){
        System.out.println("Car is created!");
    }
}
