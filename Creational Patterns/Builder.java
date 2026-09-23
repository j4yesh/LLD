
class Bike {

    private int engine;
    private int speed;
    private int acceleration;

    Bike(int engine, int speed, int acceleration) {
        this.engine = engine;
        this.speed = speed;
        this.acceleration = acceleration;
    }

    static public class BikeBuilder {

        private int engine;
        private int speed;
        private int acceleration;

        public BikeBuilder setEngine(int engine) {
            this.engine = engine;
            return this;
        }

        public BikeBuilder setSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public BikeBuilder setAcceleration(int acceleration) {
            this.acceleration = acceleration;
            return this;
        }

        public Bike build() {
            return new Bike(this.engine, this.speed, this.acceleration);
        }

    }

}

class Builder {

    public static void main(String[] jayesh) {
        Bike.BikeBuilder builder = new Bike.BikeBuilder();
        Bike b1 = builder.setEngine(1).setSpeed(1).build();
    }
}
