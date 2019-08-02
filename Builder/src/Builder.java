public class Builder {
    public static void main(String[] args) {
//        Car car = new CarBuilder()
//                .buildMake("Audi")
//                .buildTransmission(Transmission.AUTO)
//                .buildMaxSpeed(360)
//                .build();

        Director director = new Director();
        director.setBuilder(new AudiCarBuilder());
        Car car = director.buildCar();
        System.out.println(car.make + " " + car.transmission + " " + car.maxSpeed);

    }
}

enum Transmission {
    MANUAL, AUTO
}

class Car {

    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
abstract class CarBuilder{
    Car car;

    void createCar(){
        car = new Car();
    }
    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Car getCar(){
        return  car;
    }
}

class FordCarBuilder extends CarBuilder {

    @Override
    void buildMake() {
        car.setMake("Ford");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(300);
    }
}
class AudiCarBuilder extends CarBuilder {

    @Override
    void buildMake() {
        car.setMake("Audi");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(360);
    }
}

class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder carBuilder){
        this.builder = carBuilder;
    }
    Car buildCar(){
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }
}
/*class CarBuilder {
    String makeBuilder = "Default";
    Transmission transmissionBuilder = Transmission.MANUAL;
    int maxSpeedBuilder = 150;

    CarBuilder buildMake(String makeBuilder) {
        this.makeBuilder = makeBuilder;
        return this;
    }

    CarBuilder buildTransmission(Transmission transmissionBuilder) {
        this.transmissionBuilder = transmissionBuilder;
        return this;
    }

    CarBuilder buildMaxSpeed(int maxSpeedBuilder) {
        this.maxSpeedBuilder = maxSpeedBuilder;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.setMake(makeBuilder);
        car.setTransmission(transmissionBuilder);
        car.setMaxSpeed(maxSpeedBuilder);
        return car;
    }

}

 */