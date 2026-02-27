interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car is starting...");
    }

    public void stop() {
        System.out.println("Car is stopping...");
    }
}

class Truck implements Vehicle {
    public void start() {
        System.out.println("Truck is starting...");
    }

    public void stop() {
        System.out.println("Truck is stopping...");
    }
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike is starting...");
    }

    public void stop() {
        System.out.println("Bike is stopping...");
    }
}


// Vehicle Factory Method
class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equals("Car")) return new Car();
        else if (vehicleType.equals("Truck")) return new Truck();
        else if (vehicleType.equals("Bike")) return new Bike();
        else throw new IllegalArgumentException("Unknown Vehicle type...");
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        Vehicle v1 = VehicleFactory.getVehicle("Car");
        v1.start();
        v1.stop();
    }
}