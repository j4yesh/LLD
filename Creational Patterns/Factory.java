interface Vehicle{}
class Car implements Vehicle{}
class Bike implements Vehicle{}


class VehicleFactory{
        static Vehicle getVehicle(String type) throws IllegalArgumentException{
        switch(type){
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            default:
                throw new IllegalArgumentException("The requested class could not be located on the classpath.");
        }
    }
}
class Factory{

    public static void main(String [] jayesh){
        try{
            // VehicleFactory vf = new VehicleFactory();
            Vehicle car1 = VehicleFactory.getVehicle("car");
            System.out.println(car1);
        }catch(Exception e){
            System.out.println(" Error");
        }
    }
}