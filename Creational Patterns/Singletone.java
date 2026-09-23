
class Bike {

    static Bike instance;

    public static Bike getInstance() {
        if (instance == null) {
            instance = new Bike();
        }
        return instance;
    }
}

class Singletone {

    public static void main(String[] jayesh) {
        Bike b1 = Bike.getInstance();
        System.out.println(b1);

        Bike b2 = Bike.getInstance();
        System.out.println(b2);

        Bike b3 = Bike.getInstance();
        System.out.println(b3);
    }
}
