
interface SmartDevice {

    public void turnOn();

    public void turnOff();
}

class AirConditioner {

    void connectViaBluetooth() {
        System.out.println("Connecting Via Bluetooth");
    }

    void startCooling() {
        System.out.println("Starting to cooling");
    }

    void stopCooling() {
        System.out.println("Stop to cooling");
    }

    void disconnectBluetooth() {
        System.out.println("Disconnecting the bluetooth");
    }
}

class AirConditionerAdapter implements SmartDevice {

    AirConditioner airConditioner;

    public AirConditionerAdapter(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    public void turnOn() {
        this.airConditioner.connectViaBluetooth();
        this.airConditioner.startCooling();
    }

    public void turnOff() {
        this.airConditioner.stopCooling();
        this.airConditioner.disconnectBluetooth();
    }
}

class Adapter {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        AirConditionerAdapter airConditionerAdapter = new AirConditionerAdapter(airConditioner);
        airConditionerAdapter.turnOn();
        airConditionerAdapter.turnOff();
    }
}
