import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation meteoStation = new MeteoStation();
        meteoStation.addObserver(new ConsoleObserver1());
        meteoStation.setMeasurements(20, 750);
        meteoStation.setMeasurements(30, 700);
        meteoStation.addObserver(new ConsoleObserver2());
        meteoStation.setMeasurements(25, 600);
    }
}

interface Observed {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

interface Observer {
    void handleEvent(int temp, int presser);
}


class MeteoStation implements Observed {

    int temperature;
    int pressure;
    List<Observer> observerList = new ArrayList<>();

    public void setMeasurements(int t, int p){
        temperature = t;
        pressure = p;
        notifyObservers();
    }
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observerList)
            o.handleEvent(temperature, pressure);
    }
}

class ConsoleObserver1 implements Observer{
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("Observer 1 get notification: " + "Temperature "+ temp + ", pressure " + presser);
    }
}

class ConsoleObserver2 implements Observer{
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("Observer 2 get notification: " + "Temperature "+ temp + ", pressure " + presser);
    }
}