
import java.util.ArrayList;

interface SmartComponent {

    public void turnOn();

    public void turnOff();
}

class AirConditioner implements SmartComponent {

    public void turnOn() {
        System.out.println("turning on the air conditioner");
    }

    public void turnOff() {
        System.out.println("turning off the air conditioner");
    }
}

class SmartLight implements SmartComponent {

    public void turnOn() {
        System.out.println("turning on the smart light");
    }

    public void turnOff() {
        System.out.println("turning off the smart light");
    }
}

class CompositeSmartComponent implements SmartComponent {

    ArrayList<SmartComponent> smartComponents;

    public CompositeSmartComponent() {
        this.smartComponents = new ArrayList<>();
    }

    public void turnOn() {
        for (SmartComponent cur : smartComponents) {
            cur.turnOn();
        }
    }

    public void turnOff() {
        for (SmartComponent cur : smartComponents) {
            cur.turnOff();
        }
    }

    public void addComponent(SmartComponent comp) {
        this.smartComponents.add(comp);
    }

    public void removeComponent(SmartComponent comp) {
        this.smartComponents.remove(comp);
    }

}

class Composite {

    public static void main(String[] jayesh) {
        CompositeSmartComponent csc = new CompositeSmartComponent();
        SmartComponent sc1 = new SmartLight();
        SmartComponent sc2 = new AirConditioner();
        csc.addComponent(sc2);
        csc.addComponent(sc1);
        csc.turnOn();
        csc.removeComponent(sc2);
        csc.turnOff();
    }
}
