public class BridgeApp {
    public static void main(String[] args) {

        Car car = new Sedan(new Mers());
        car.showDetails();
    }
}

abstract class Car{
    Make make;
    Car(Make m){
        make = m;
    }
    abstract void showType();
    void showDetails(){
        make.setMake();
        showType();
    }
}
class Sedan extends Car{

    public Sedan(Make m) {
        super(m);
    }

    @Override
    void showType() {
        System.out.println("Sedan");
    }
}

class Hatchback extends Car{

    public Hatchback(Make m) {
        super(m);
    }

    @Override
    void showType() {
        System.out.println("Hatchback");
    }
}

interface Make{
    void setMake();
}

class Kia implements Make{

    @Override
    public void setMake() {
        System.out.println("Kia");
    }
}

class Ford implements Make{

    @Override
    public void setMake() {
        System.out.println("Ford");
    }
}
class Mers implements Make{

    @Override
    public void setMake() {
        System.out.println("Mers");
    }
}
