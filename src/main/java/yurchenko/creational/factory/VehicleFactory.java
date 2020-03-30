package yurchenko.creational.factory;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicle) {
        switch (vehicle) {
            case "car":
                return new CarFactory();
            case "bus":
                return new BusFactory();
            default:
                return null;
        }
    }
}
