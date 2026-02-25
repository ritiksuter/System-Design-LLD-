interface Vehicle {
  void start();
  void stop();
}
// Concrete Classes for Car Brands
class Honda implements Vehicle {
  public void start() {
    System.out.println("Honda Car is starting");
  }
  public void stop() {
    System.out.println("Honda Car is stopping");
  }
}
class Toyota implements Vehicle {
  public void start() {
    System.out.println("Toyota Car is starting");
  }
  public void stop() {
    System.out.println("Toyota Car is stopping");
  }
}
class BMW implements Vehicle {
  public void start() {
    System.out.println("BMW Car is starting");
  }
  public void stop() {
    System.out.println("BMW Car is stopping");
  }
}
// Abstract Factory Interface
interface VehicleFactory {
  Vehicle createVehicle();
}
// Concrete Factories for Each Car Brand
class HondaFactory implements VehicleFactory {
  public Vehicle createVehicle() {
    return new Honda();
  }
}
class ToyotaFactory implements VehicleFactory {
  public Vehicle createVehicle() {
    return new Toyota();
  }
}
class BMWFactory implements VehicleFactory {
  public Vehicle createVehicle() {
    return new BMW();
  }
}
// Client Code
public class AbstractFactoryPattern {
  public static void main(String[] args) {
    VehicleFactory hondaFactory = new HondaFactory();
    Vehicle honda = hondaFactory.createVehicle();
    honda.start();
    honda.stop();
    VehicleFactory toyotaFactory = new ToyotaFactory();
    Vehicle toyota = toyotaFactory.createVehicle();
    toyota.start();
    toyota.stop();
  }
}