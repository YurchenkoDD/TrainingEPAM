package yurchenko.creational.factory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vechicleFactory = new VehicleFactory();

        Vehicle car = vechicleFactory.getVehicle("car");
        car.produce();

        Vehicle bus = vechicleFactory.getVehicle("bus");
        bus.produce();
    }
}
