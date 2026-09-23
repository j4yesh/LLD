
interface Factory {

    public Vehicle getVehicle();
}

interface Vehicle {
}

class BMW implements Vehicle {
}

class KTM implements Vehicle {
}

class BMWfactory implements Factory {

    public Vehicle getVehicle() throws IllegalArgumentException {
        return new BMW();
    }

}

class KTMfactory implements Factory {

    public Vehicle getVehicle() throws IllegalArgumentException {
        return new KTM();
    }

}

class AbstractFactory {

    public static void main(String[] jayesh) {

        Factory ktmFactory = new KTMfactory();
        Vehicle ktm = ktmFactory.getVehicle();

        Factory bmwFactory = new BMWfactory();
        Vehicle bmw = bmwFactory.getVehicle();

        System.out.println(ktm);
        System.out.println(bmw);
    }
}
