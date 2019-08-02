import java.util.Date;

public class FactoryMethod{
    public static void main(String[] args) {
//        Watch watch = new DigitalWatch();
//        watch.showTime();
//        watch = new RomeWatch();
//        watch.showTime();

        WatchMaker maker = new DigitalWatchMaker();
        Watch watch = maker.getWatch();
        watch.showTime();

        WatchMaker maker1 = new RomeWatchMaker();
        Watch watch1 = maker1.getWatch();
        watch1.showTime();
    }
}



interface Watch {
    void showTime();
}

class DigitalWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}
class RomeWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker{
    Watch getWatch();
}
class DigitalWatchMaker implements WatchMaker {
    @Override
    public Watch getWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch getWatch() {
        return new RomeWatch();
    }
}