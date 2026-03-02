import java.util.ArrayList;
import java.util.List;

interface SmartComponent {
    void turnOn(); // Turn on the component

    void turnOff(); // Turn off the component
}

class AirConditioner implements SmartComponent {
    @Override
    public void turnOn() {
        System.out.println("Air Conditioner is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Air Conditioner is now OFF.");
    }
}

class SmartLight implements SmartComponent {
    @Override
    public void turnOn() {
        System.out.println("Smart Light is now ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart Light is now OFF.");
    }
}

class CompositeSmartComponent implements SmartComponent {
    private List<SmartComponent> components = new ArrayList<>();

    public void addComponent(SmartComponent component) {
        components.add(component);
    }

    public void removeComponent(SmartComponent component) {
        components.remove(component);
    }

    @Override
    public void turnOn() {
        for (SmartComponent component : components) {
            component.turnOn();
        }
    }

    @Override
    public void turnOff() {
        for (SmartComponent component : components) {
            component.turnOff();
        }
    }
}

public class CompositeDesign {
    public static void main(String[] args) {
        SmartComponent airConditioner = new AirConditioner();
        SmartComponent smartLight = new SmartLight();

        CompositeSmartComponent room1 = new CompositeSmartComponent();
        room1.addComponent(airConditioner);
        room1.addComponent(smartLight);

        CompositeSmartComponent room2 = new CompositeSmartComponent();
        room2.addComponent(new AirConditioner());
        room2.addComponent(new SmartLight());

        CompositeSmartComponent floor = new CompositeSmartComponent();
        floor.addComponent(room1);
        floor.addComponent(room2);

        CompositeSmartComponent house = new CompositeSmartComponent();
        house.addComponent(floor);

        house.turnOn();
        house.turnOff();
        floor.turnOff();
        room1.turnOff();
    }
}