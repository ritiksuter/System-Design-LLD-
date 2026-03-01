interface TrafficLightState {
    void next(TrafficLightContext context);

    String getColor();
}

class RedState implements TrafficLightState {
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching Red to green");
        context.setState(new GreenState());
    }

    @Override
    public String getColor() {
        return "RED";
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from GREEN to YELLOW. Slow down!");
        context.setState(new YellowState());
    }

    @Override
    public String getColor() {
        return "GREEN";
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Switching from YELLOW to RED. Stop!");
        context.setState(new RedState());
    }

    @Override
    public String getColor() {
        return "YELLOW";
    }
}

class TrafficLightContext {
    private TrafficLightState currentState;

    public TrafficLightContext() {
        currentState = new RedState();
    }

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void next() {
        currentState.next(this);
    }

    public String getColor() {
        return currentState.getColor();
    }
}

public class StateDesignPattern {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();
        trafficLight.next(); // RED -> GREEN
        trafficLight.next(); // GREEN -> YELLOW
        trafficLight.next(); // YELLOW -> RED
        trafficLight.next(); // RED -> GREEN
    }
}