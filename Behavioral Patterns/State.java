
interface TrafficLightState {

    public String getColor();

    public void nextState(TrafficLightContext tlc);
}

class RedState implements TrafficLightState {

    private String color = "red";

    public void nextState(TrafficLightContext tlc) {
        tlc.setState(new GreenState());
    }

    public String getColor() {
        return this.color;
    }
}

class GreenState implements TrafficLightState {

    private String color = "green";

    public void nextState(TrafficLightContext tlc) {
        tlc.setState(new RedState());
    }

    public String getColor() {
        return this.color;
    }
}

class TrafficLightContext {

    TrafficLightState tls;

    public TrafficLightContext() {
        tls = new RedState();
    }

    public void nextState() {
        tls.nextState(this);
    }

    public void setState(TrafficLightState tls) {
        this.tls = tls;
    }

    public String getColor() {
        return this.tls.getColor();
    }
}

class State {

    public static void main(String[] jayesh) {
        TrafficLightContext tlc = new TrafficLightContext();
        System.out.println(tlc.getColor());
        tlc.nextState();
        System.out.println(tlc.getColor());
        tlc.nextState();
        System.out.println(tlc.getColor());
        tlc.nextState();
        System.out.println(tlc.getColor());
        tlc.nextState();
        System.out.println(tlc.getColor());
    }
}
